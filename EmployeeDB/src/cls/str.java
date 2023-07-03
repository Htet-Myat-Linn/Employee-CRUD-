package cls;

public class str {
	public static void main(String[] args) {
        // TODO code application logic here
        int t=1;
        if(t==1)
        {
        	int len=String.valueOf(40000000).length();
        	System.out.println(len);
        	int index=0;
        	StringBuffer str=new StringBuffer("");
        	for (int i = 0; i<8; i++)
        	{
        		if(index==3)
        		{
        			str.append(",");
        			index=0;
        			i--;
        			System.out.println(i+"i");
        		
        		}
        		else
        		{
        			str.append(String.valueOf(40000000).charAt(len-1));
        			index++;
        			String a=String.valueOf(40000000);
        			System.out.println(a.charAt(len-i-1)+"q");
        			System.out.println(str);
        		}
        	}
        	System.out.println (str.reverse().toString());
        }
    }

}
