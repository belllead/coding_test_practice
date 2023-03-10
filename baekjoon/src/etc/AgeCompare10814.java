package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.StringTokenizer;

public class AgeCompare10814 {
	
    static class Person implements Comparable<Person> {
        int age;
        String name;

        public Person(int age, String name) {
            this.age = age;
            this.name = name;
        }

		@Override
		public int compareTo(Person p) {
			return this.age - p.age;
		}

		@Override
		public String toString() {
			return age + " " + name;
		}
		
		
    }
    
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
    	int N = Integer.parseInt(br.readLine());
    	
    	Person[] p = new Person[N];
    	
    	StringTokenizer st = null;
    	for (int i=0; i<N; i++) {
    		st = new StringTokenizer(br.readLine());
    		int age = Integer.parseInt(st.nextToken());
    		String name = st.nextToken();
    		
    		p[i] = new Person(age, name); 
    	}
    	
    	for (int i=0; i<N-1; i++) {
    		for (int j=i+1; j<N; j++) {
    			if (p[i].compareTo(p[j]) > 0) {
        			Person temp = p[i];
        			p[i] = p[j];
        			p[j] = temp;
        		}
    		}
    	}
    	
    	for (int i=0; i<N; i++) {
    		System.out.println(p[i]);
    	}
    	
    	
    }
}
