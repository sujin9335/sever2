package com.test;

import java.util.ArrayList;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n=sc.nextInt();
		
		ArrayList<num> list=new ArrayList<num>();
		
		for(int i=0; i<n; i++) {
			num re=new num();
			re.h=sc.nextInt();
			re.w=sc.nextInt();
			re.n=sc.nextInt();
			
			list.add(re);
		}
		
		
		
		for(int i=0; i<list.size(); i++) {
			int f=0;
			int e=0;

			if(list.get(i).n % list.get(i).h == 0) {
				f=list.get(i).h;
				e=list.get(i).n / list.get(i).h;
				
			}else {
				f=list.get(i).n % list.get(i).h;
				e=list.get(i).n / list.get(i).h +1;
			}
			String e2=String.format("%02d", e);
			System.out.println(f+""+e2);
			
		}
		
		
		sc.close();
	}
}

class num {

	int h;
	int w;
	int n;

}
