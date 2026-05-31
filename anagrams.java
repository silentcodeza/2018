import java.util.*;
import java.io.*;

public class anagrams
{


	public static String Sort(String s)
	{
		char[] charArray = new char[s.length()];
		s.getChars(0,s.length(),charArray,0);
		java.util.Arrays.sort(charArray);
		return new String(charArray);
	}


	public static boolean isInList(List<String> myList,String value){

			for(String val:myList){

           if (val.compareToIgnoreCase(value)==0)
					  			return true;
			}
		return false;
	}
	public static void main(String[]args){

		Hashtable<String,Integer> hashtable1 = new Hashtable<String, Integer>();

		Map<String, ArrayList<String>> hashtable2 = new HashMap<String, ArrayList<String>>();



		String [] wordArray = new String[2000000];
		try
		{
				int i = 0;
				Scanner file = new Scanner(new File("data.ulysses"));
				//Scanner file = new Scanner(new File("/export/home/notes/ds/data/data.ulysses"));
				while(file.hasNext()) //reading and spliting the sentences from the file into an array of strings
				{	String raWord = file.next();
					String cleanWord = raWord.replaceAll("[^A-Za-z']","").toLowerCase(); //using the negation regex to preserve all these characters
					wordArray[i] = cleanWord;
					i++;
				}

				int j = 0;
				String[] anagrams = new String[1514];//i debugged as found the number of anagrams to be exactly this number
				for(int k=0;k<i;k++)
				{
					ArrayList currList = new ArrayList<String>(); //using arrayylist so that i will store more than one value to one key
					String alphaWord = Sort(wordArray[k]); //aphabetised word calling the above method
					if((hashtable2.get(alphaWord))==null){ //to avoid the freaking nullpointer
							currList.add(wordArray[k]);
							hashtable2.put(alphaWord,currList);
							hashtable1.put(alphaWord,1);
					}
					else{
						currList = hashtable2.get(alphaWord);

					if(hashtable1.containsKey(alphaWord) && !isInList(currList,wordArray[k])) //need to avoid repettitions
					{
						Integer l = hashtable1.get(alphaWord); //this is the frequency of the word
						hashtable1.put(alphaWord,++l);
						currList.add(wordArray[k]);
						hashtable2.put(alphaWord,currList);
						if (l==2){ //storing anagrams into an array, one they have a frequency of 2
							anagrams[j] = alphaWord;
							j++;}
					}
					}
			}
			java.util.Arrays.sort(anagrams);//built in method to sort them just to make them appear alphabetically
			for(int m=0;m<j;m++){
				System.out.println("{\""+ anagrams[m] +"\" : "+ hashtable2.get(anagrams[m])+"}"); //just to make it look cute
			}
		}
		catch(FileNotFoundException e)
		{
				System.out.println("File not found");
		}
	}
}
