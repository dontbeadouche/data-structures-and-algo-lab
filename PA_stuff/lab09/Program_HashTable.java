import java.util.*;

class DNS{

  String host, ip;

  DNS(String host, String ip){

    this.host = host;
    this.ip = ip;
  }
}
class MyDNSHashTable{

  ArrayList <DNS> table [];

  MyDNSHashTable(){

    table = new ArrayList[17];

    for(int i = 0; i < table.length; i++){
      table[i] = new ArrayList <DNS> ();      // Implementing Separate Chaining thorugh an ArrayList of ArrayList(s)
    }
  }

  public long compressionMap(long key){
    return key % 17L;
  }

  public long hashCodeMap(String host){

    char[] data = host.toCharArray();
    long value = 0;
    int a = 33;
    int len = data.length;

    for(int i = 0; i < len; i++){

      value *= a;
      value += (int) data[len - 1 - i];       // Horner's rule polynomial accumulation
    }
    return value;
  }

  public void insert(DNS dns){

    int index = (int) compressionMap(hashCodeMap(dns.host));
    table[index].add(dns);
  }

  public void find(String hostname){

    int index = (int) compressionMap(hashCodeMap(hostname));
    System.out.println("\nComputed index : " + index);

    if(table[index] == null){
      System.out.println(hostname + " mapping not found in the Hash Table");
      return;
    }

    ArrayList <DNS> list = table[index];

    for(int i = 0; i < list.size(); i++){

      if(list.get(i).host.compareTo(hostname) == 0){
        System.out.println(hostname + " mapping found in the Hash table with IP address " + list.get(i).ip);
        return;
      }
    }
    System.out.println(hostname + " mapping not found in the Hash Table");
  }

  public void display(){

    ArrayList <DNS> list;
    System.out.println();
    for(int i = 0; i < table.length; i++){
      list = table[i];
      System.out.println("Hash Table index : " + i);

      for(DNS temp : list){
        System.out.println("host : " + temp.host + "\tip : " + temp.ip);
      }
      System.out.println();
    }
  }
}

class Program_HashTable{

  public static void main(String[] args) {

    MyDNSHashTable table = new MyDNSHashTable();

    table.insert(new DNS("google.com","172.217.11.174"));
    table.insert (new DNS ("bbc.co.uk", "212.58.241.131"));
    table.insert (new DNS ("youtube.com","74.125.65.91"));
    table.insert (new DNS ("yahoo.com", "98.137.149.56"));
    table.insert (new DNS ("reddit.com", "173.231.140.219"));
    table.insert (new DNS ("thepiratebay.org", "194.71.107.15"));
    table.insert (new DNS ("facebook.com", "31.13.77.36"));
    table.insert (new DNS ("twitter.com", "199.59.149.230"));
    table.insert (new DNS ("amazon.com", "72.21.211.176"));
    table.insert (new DNS ("fileshare.com", "208.87.33.151"));
    table.insert (new DNS ("putlocker.com", "89.238.130.247"));
    table.insert (new DNS ("videoweed.com", "91.220.176.248"));
    table.insert (new DNS ("blogtv.com", "84.22.170.149"));

    table.display();
    
    table.find("google.com");
    table.find("bbc.co.uk");
    table.find("youtube.com");
    table.find("apple.com");
  }
}
