package main.resource;

import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;
import org.w3c.dom.*;
import java.util.*;
import java.io.*;


public class Optimization extends xQueryBaseVisitor<List<Node>> {
    public xQueryParser.XQFLWORContext contex;
    StringBuilder OptimizedQuery = new StringBuilder();


    List<Map<String,String>> classifier = new ArrayList<>();

    List<List<String>> conds = new ArrayList<>();
    List<List<Integer>> condsClassifier = new ArrayList<>();
    boolean needToRewrite = true;

    Optimization(xQueryParser.XQFLWORContext contex)
    {
        this.contex = contex;
    }

    public String rewrite()
    {
        //1. Analyze
        analyzer();


        if(classifier.size() == 1 || !needToRewrite)
        {
            return "Don't need to rewrite.";
        }

        OptimizedQuery.append("for $tuple in");

        for (int i=1;i<classifier.size();i++)
        {
            OptimizedQuery.append(" join (");
        }

        //2. Rewrite statement "for $tuple in join  ... "
        for(int i=1;i<classifier.size();i++)
        {
            reconstructorJoinStatement(i);
            //最后一个没逗号！前面有逗号！
            if(i!=classifier.size()-1)
            {
                OptimizedQuery.append(",\n");
            }
            else
            {
                OptimizedQuery.append("\n");
            }
        }

        //3. Rewrite statement "return ... "
        reconstructorReturnStatement();

//        System.err.println(OptimizedQuery.toString());
        System.out.println("successfully rewrite");
        try
        {
            File file = new File("./rewrite.txt");
            FileWriter writer = new FileWriter(file,false);
            writer.write(OptimizedQuery.toString());
            writer.close();
        }
        catch(Exception e)
        {
            System.err.println("Error in rewrite to file" + e.getMessage());
        }

        //System.out.println(OptimizedQuery.toString());
        return OptimizedQuery.toString();
    }

    //1. analyzer
    private void analyzer()
    {
        //1.1 Classify: split all variables in for statement into different join parts.
        //  for $b in doc("input")/book,
        //      $a in doc("input")/entry,
        //      $tb in $b/title,
        //      $ta in $a/title
        //  e.g. classifies = [[$b,doc("input")/book], [$tb,$b/title]],
        //                    [[$a,doc("input")/entry], [$ta,$a/title]]
        int numVarsInFor = contex.forClause().var().size();

        if (numVarsInFor == 0) {
            needToRewrite = false;
            return;
        }

        for(int i=0;i<numVarsInFor;i++)
        {
            String var = contex.forClause().var(i).getText();
            String xq = contex.forClause().xq(i).getText();
            String xqPrefix = xq.split("/")[0];

            //if xqPrefix is not a var...
            if(!xqPrefix.substring(0,1).equals("$"))
            {
                //e.g. first line above, varPrefix == "doc("input")"
                //Use LinkedHashMap rather than HashMap in order to make sure
                //the key is ordered.
                Map<String,String> map = new LinkedHashMap<>();
                map.put(var,xq);
                classifier.add(map);
            }

            for(Map map:classifier) {
                if(map.containsKey(xqPrefix)) {
                    map.put(var,xq);
                    break;
                }
            }
            //这里的写法不确定对不对，我把found直接省掉了
            //因为理论上说，只要varPrefix是个变量，在classfier里面一定找得到
        }

        //1.2 Split the where statement, and store conds in a list.
        //    then, find if the var in conds statement also exists in for statements.
        //    if it is, set num in condClassifiers as same as num of this var in classifier.
        //    if not, set -1.
        // where $aj eq "John" and $af1 eq $af21
        //e.g. conds = [[$aj, John], [af1,af2]], condsClassifier = [[0,-1], [0,1]]

        //List<String> condStrs = new ArrayList<>();

        int findWhereIndex = contex.getText().toString().indexOf("where");
        if (findWhereIndex == -1) {
            needToRewrite = false;
            return;
        }

        getcondsRecursively(contex.whereClause().cond(), conds);

        for(List<String> listStr:conds) {

            List<Integer> listInt = new ArrayList<>();
            condsClassifier.add(listInt);
            listInt.add(-1);listInt.add(-1);

            int j=0;
            for(Map map:classifier) {
                if(map.containsKey(listStr.get(0))) {
                    listInt.set(0,j);
                }
                if(map.containsKey(listStr.get(1))) {
                    listInt.set(1,j);
                }
                j++;
            }

        }
    }

    private void getcondsRecursively(xQueryParser.CondContext cond, List<List<String>> condStrs)
    {
        //System.err.println(cond.getClass().toString());
        if(cond.getClass().toString().equals("class xQueryParser$XQAndCondContext"))
        {
            xQueryParser.XQAndCondContext newcond = (xQueryParser.XQAndCondContext) cond;
            getcondsRecursively(newcond.cond(0),condStrs);
            getcondsRecursively(newcond.cond(1),condStrs);
        }
        else if(cond.getClass().toString().equals("class xQueryParser$XQEqualcondContext"))
        {
            xQueryParser.XQEqualContext newcond = (xQueryParser.XQEqualContext)cond;
            List<String> list = new ArrayList<>();
            condStrs.add(list);
            list.add(newcond.xq(0).getText());
            list.add(newcond.xq(1).getText());
        }
    }

    //2. Rewrite statement "for $tuple in join ... "
    private void reconstructorJoinStatement(int n)
    {
        //2.1 assign the left deep join sequences
        //e.g. classifier.size == 4, join(join(join(A, B), C), D)
        int start,end;
        if(n == 1)
        {
            start = 0;
            end = 2;
        }
        else
        {
            start = n;
            end = n+1;
        }


        for(int i=start;i<end;i++)
        {
            //2.2 print for...
            //e.g. for $b1 in doc("input")/book,
            //         $aj in $b1/author/first/text(),
            Map<String,String> map = classifier.get(i);
            int k=0;
            for(String key:map.keySet())
            {
                if(k!=0)
                {
                    OptimizedQuery.append(",\n\t");
                }
                if(k==0)
                {
                    OptimizedQuery.append("for ");
                }
                OptimizedQuery.append(key).append(" in ").append(map.get(key));
                k++;
            }
            //注意：最后一个for后面没逗号。！！！！！！！！！
            OptimizedQuery.append("\n\t");

            //2.3 print where...
            //e.g. where $aj eq "Joshn"
            k=0;
            for(int j=0;j<conds.size();j++) {
                //This first element in cond is a variale and the second one is not.
                //e.g. where $aj eq "John"
                //!!!这里值得注意。会不会有where "John" eq $b的情况？
                if((condsClassifier.get(j).get(1) == -1 && map.containsKey(conds.get(j).get(0))) ||
                        (condsClassifier.get(j).get(0) == -1 && map.containsKey(conds.get(j).get(1))))
                {
                    if(k == 0)
                    {
                        OptimizedQuery.append("where ");
                    }
                    else
                    {
                        OptimizedQuery.append(" and ");
                    }

                    OptimizedQuery.append(conds.get(j).get(0)).append(" eq ").append(conds.get(j).get(1));
                    OptimizedQuery.append("\n\t");
                    k++;
                }
            }

            //2.4 print return
            //e.g. return <tuple>
            //         <b1>{$b1}</b1>,
            //         <aj>{$aj}</aj>
            //</tuple>,
            OptimizedQuery.append("return <tuple>{\n\t");
            k=0;
            for(String key:map.keySet())
            {
                if(k!=0)
                {
                    OptimizedQuery.append(",\n\t");
                }
                OptimizedQuery.append("<"+key.substring(1)+">");
                OptimizedQuery.append("{"+key+"}");
                OptimizedQuery.append("</"+key.substring(1)+">");
                k++;
            }
            OptimizedQuery.append("\n\t");
            OptimizedQuery.append("}</tuple>,\n");

        }

        //2.5 join(A,B,C,D) here is for generate C and D.
        //e.g. n=2, conds which satisfies our demand: "$af22 eq $af3" and "$al22 eq $al3"
        // listC = [af22, al22], listD = [af3, al3]
        List<String> listC = new ArrayList<>();
        List<String> listD = new ArrayList<>();

        //这里只处理这样的conds: $a eq $b, 其中$a属于第n个分类，$b属于第n-1个分类；或者反过来
        for(int i=0;i<conds.size();i++)
        {
            if (condsClassifier.get(i).get(0) == n &&
                    (condsClassifier.get(i).get(1) >= 0 && condsClassifier.get(i).get(1) < n))
            {
                listC.add(conds.get(i).get(1));
                listD.add(conds.get(i).get(0));
            }
            else if(condsClassifier.get(i).get(1) == n &&
                    (condsClassifier.get(i).get(0) >= 0 && condsClassifier.get(i).get(0) < n))
            {
                listC.add(conds.get(i).get(0));
                listD.add(conds.get(i).get(1));
            }
        }
        OptimizedQuery.append("\n\t[");
        int k=0;
        for(String str:listC) {
            if(k!=0)
            {
                //注意：最后一个后面没逗号！！！！！！！！！
                OptimizedQuery.append(",");
            }
            OptimizedQuery.append(str.substring(1));
            k++;
        }
        OptimizedQuery.append("],[");

        k=0;
        for(String str:listD) {
            if(k!=0)
            {
                //注意：最后一个后面没逗号！！！！！！！！！
                OptimizedQuery.append(",");
            }
            OptimizedQuery.append(str.substring(1));
            k++;
        }
        OptimizedQuery.append("])");

    }

    //3. Rewrite statement "return ... "
    //e.g. return <triplet> {$b1, $b2, $b3} </triplet>   ->
    //     return <triplet> {$tuple/b1/*, $tuple/b2/*, $tuple/b3/*} </triplet>
    private void reconstructorReturnStatement()
    {
        OptimizedQuery.append("return\n");
        getReturnRecursively(contex.returnClause().xq());
        OptimizedQuery.append("\n");
    }

    //
    private void getReturnRecursively(xQueryParser.XqContext xq)
    {
        //'<' Name '>' '{' xq '}' '<' '/' Name '>'
        if(xq.getClass().toString().equals("class xQueryParser$TagXQContext"))
        {
            xQueryParser.XQNodeConstrctorContext tagXQ = (xQueryParser.XQNodeConstrctorContext)xq;
            OptimizedQuery.append("<" + tagXQ.NAME(0) + ">{" );
            getReturnRecursively(tagXQ.xq());
            OptimizedQuery.append("}</" + tagXQ.NAME(1) + "> " );
        }
        //xq , xq
        else if(xq.getClass().toString().equals("class xQueryParser$CommaXQContext"))
        {
            xQueryParser.XQConcatContext CommaXQ = (xQueryParser.XQConcatContext)xq;
            getReturnRecursively(CommaXQ.xq(0));
            OptimizedQuery.append(", ");
            getReturnRecursively(CommaXQ.xq(1));
        }
        //other conds
        else
        {
            String xqStr = xq.getText();
            //$b/price -> $tuple/b/*/price
            if(xqStr.contains("/"))
            {
                String[] xqStrs = xqStr.split("/",2);
                OptimizedQuery.append("$tuple/" + xqStrs[0].substring(1) + "/*/" + xqStrs[1]);
            }
            //$tb -> $tuple/tb/*
            else
            {
                OptimizedQuery.append("$tuple/" + xqStr.substring(1) + "/*");
            }
        }
    }
}
