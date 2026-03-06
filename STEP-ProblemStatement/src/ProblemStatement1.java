```java id="y2rj0m"
import java.util.*;

public class ProblemStatement1 {

    static class Transaction {
        int id;
        int amount;
        String merchant;
        int time;
        String account;

        Transaction(int id,int amount,String merchant,int time,String account){
            this.id=id;
            this.amount=amount;
            this.merchant=merchant;
            this.time=time;
            this.account=account;
        }
    }

    public static void main(String[] args) {

        List<Transaction> list=new ArrayList<>();

        list.add(new Transaction(1,500,"StoreA",600,"acc1"));
        list.add(new Transaction(2,300,"StoreB",615,"acc2"));
        list.add(new Transaction(3,200,"StoreC",630,"acc3"));
        list.add(new Transaction(4,500,"StoreA",640,"acc4"));

        findTwoSum(list,500);
        detectDuplicates(list);
        findKSum(list,3,1000);
    }

    static void findTwoSum(List<Transaction> list,int target){

        HashMap<Integer,Transaction> map=new HashMap<>();

        for(Transaction t:list){

            int comp=target-t.amount;

            if(map.containsKey(comp)){
                Transaction x=map.get(comp);
                System.out.println("Pair: "+x.id+" "+t.id);
            }

            map.put(t.amount,t);
        }
    }

    static void detectDuplicates(List<Transaction> list){

        HashMap<String,List<String>> map=new HashMap<>();

        for(Transaction t:list){

            String key=t.amount+"-"+t.merchant;

            if(!map.containsKey(key)){
                map.put(key,new ArrayList<>());
            }

            map.get(key).add(t.account);
        }

        for(String k:map.keySet()){
            List<String> acc=map.get(k);
            if(acc.size()>1){
                System.out.println("Duplicate "+k+" accounts "+acc);
            }
        }
    }

    static void findKSum(List<Transaction> list,int k,int target){

        int n=list.size();

        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                for(int m=j+1;m<n;m++){

                    int sum=list.get(i).amount+list.get(j).amount+list.get(m).amount;

                    if(sum==target){
                        System.out.println("KSum: "+list.get(i).id+" "+list.get(j).id+" "+list.get(m).id);
                    }
                }
            }
        }
    }
}
