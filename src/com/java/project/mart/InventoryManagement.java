package com.java.project.mart;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;


public class InventoryManagement {
	
	private static Scanner scan;
	private static ArrayList<Product> list;
	
	static {
		scan = new Scanner(System.in);
		list = new ArrayList<Product>();
	}
	
	
	public InventoryManagement() throws Exception {
		
		boolean loop = true;
		
		while (loop) {
			
			menu();
		
			System.out.print("μλ ₯: ");
			String nums1 = scan.nextLine();
			
			if (nums1.equals("1")) {
				
				productadd();
				
			} else if (nums1.equals("2")) {
				
				productlist();
			} else if (nums1.equals("3")) {
				
				loop = false;
			} else {
				
				System.out.println();
				System.out.println("π₯ μ¬λ°λ₯Έ λ²νΈλ₯Ό μλ ₯ν΄μ£ΌμΈμ. π₯");
				System.out.println();
			}
		}
		
	}

	private static void menu() {
		
			
		System.out.println();
		System.out.println("μνμλ λ©λ΄λ₯Ό μ νν΄μ£ΌμΈμ.");
		System.out.println("βββββββββββββββββ");
		System.out.println("1. μν μκ³ ");
		System.out.println("2. μν μ¬κ³  μ‘°ν");
		System.out.println("3. λ€λ‘κ°κΈ°");
		System.out.println("βββββββββββββββββ");
		System.out.println(
				"οΏ£οΏ£οΏ£οΏ£οΏ£οΌΌοΌοΏ£οΏ£οΏ£οΏ£\r\n"
				+ "γγγγ β§οΌΏβ§γγγγ\r\n"
				+ "γγγοΌΒ΄γ»Ογ»οΌ γ\r\n"
				+ "γοΌΏοΌΏ_(γ£ ζ¦oοΌΏοΌΏ\r\n"
				+ "γ|lοΏ£l||οΏ£γοΎγοΎοΏ£|i\r\n"
				+ "");
		System.out.println();
		
	}

	private static void productlist() throws Exception {
		
		System.out.println("                          ββββββββββββββ");
		System.out.println("                                λ§νΈ μν λ¦¬μ€νΈ");
		System.out.println("                          ββββββββββββββ");
		System.out.println("ββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββ");
		System.out.println();
		System.out.println("     [λ²νΈ]      [μμ°μ§]      [μλ]          [κ°κ²©]                       [μνλͺ]");
		
		BufferedReader reader = new BufferedReader(new FileReader(Path.PRODUCTDIR));
		
		String line = null;
		String txt = "";
		
		while ((line = reader.readLine()) != null) {
			
			String[] temp = line.split(",");

			txt += String.format("     %3s           %2s        %,5dκ°     %,10dμ     %20s\r\n" 
					, temp[0] //λ²νΈ
					, temp[3] //μ μ‘°μ¬(μμ°μ§)
					//, temp[2] μΉ΄νκ³ λ¦¬ 
					, Integer.parseInt(temp[7]) 
					//, temp[4]  κ²μμ΄
					//, temp[5] λ² μ§νλ¦¬μΈ 
					//, temp[6] λ―Έμ±λμ
					, Integer.parseInt(temp[8]) //μλ
					, temp[1]); //μνλͺ
		}
		System.out.println(txt);
		System.out.println("ββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββ");
		reader.close();
		
		boolean loop = true;
		
		while (loop) {
			System.out.println();
			System.out.println("λ€λ₯Έ λ©λ΄λ‘ μ΄λμ μνμ€ κ²½μ° μ«μλ₯Ό μλ ₯ν΄μ£ΌμΈμ.");
			System.out.println("βββββββββββββββββ");
			System.out.println("1. μν μκ³ ");
			System.out.println("2. λ€λ‘κ°κΈ°");
			System.out.println("βββββββββββββββββ");
			System.out.println(
					"οΏ£οΏ£οΏ£οΏ£οΏ£οΌΌοΌοΏ£οΏ£οΏ£οΏ£\r\n"
					+ "γγγγ β§οΌΏβ§γγγγ\r\n"
					+ "γγγοΌΒ΄γ»Ογ»οΌ γ\r\n"
					+ "γοΌΏοΌΏ_(γ£ ζ¦oοΌΏοΌΏ\r\n"
					+ "γ|lοΏ£l||οΏ£γοΎγοΎοΏ£|i\r\n"
					+ "");
			
			System.out.println();
			System.out.print("μλ ₯: ");
			String input = scan.nextLine();
			System.out.println();
			
			if (input.equals("1")) {
				
				productadd();
			} else if (input.equals("2")) {
				
				System.out.println();
				loop = false;
			} else {
				
				System.out.println("π₯ μ¬λ°λ₯Έ λ²νΈλ₯Ό μλ ₯ν΄μ£ΌμΈμ. π₯");
				System.out.println();
			}
			
		}
		
		
	}

	 private static void productadd() throws Exception {
	      
	      System.out.println();
	      System.out.println("μκ³ νμλ €λ μνμ μ΄λ¦κ³Ό μλμ μλ ₯ν΄μ£ΌμΈμ.");
	      System.out.println();
	      
	      boolean loop = true;
	      String productname="";
	      
	      while(loop) {
		      System.out.print("μνλͺ: ");
		      productname = scan.nextLine();
		      
		      if (productname.equals("")) {
					System.err.println("π₯ μνλͺμ μλ ₯ν΄μ£ΌμΈμ π₯");
				}else {
					loop = false;
				}
		      
	      }
	      System.out.println();
	      String productcount="";
	      loop = true;
	      while(loop) {
	    	  System.out.print("μλ: ");
	    	  productcount = scan.nextLine();
		     
		      if (productcount.equals("")) {
					System.err.println("π₯ μλμ μλ ₯ν΄μ£ΌμΈμ π₯");
				}else {
					loop = false;
				}
		      
	      }
	    
	      System.out.println();
	      
	      BufferedReader reader = new BufferedReader(new FileReader(Path.PRODUCTDIR));
	      
	      String line = null;
	      String txt = "";
	      
	      while ((line = reader.readLine()) != null) {
	         
	         String[] temp = line.split(",");
	            
	         if (productname.equals(temp[1])) {
	            
	            int count = Integer.parseInt(temp[7]);
	            
	            count += Integer.parseInt(productcount);
	            
	            temp[7] = Integer.toString(count);
	            
	         }
	         
	         txt += String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s\r\n"
	                     , temp[0]
	                     , temp[1]
	                     , temp[2]
	                     , temp[3]
	                     , temp[4]
	                     , temp[5]
	                     , temp[6]
	                     , temp[7]
	                     , temp[8]);
	      }
	      
	      reader.close();
	      
	      BufferedWriter writer = new BufferedWriter(new FileWriter(Path.PRODUCTDIR));
	      
	      writer.write(txt);
	      
	      writer.close();
	      
	      System.out.println("μκ³ λμμ΅λλ€.\r\n");

	      loop = true;
	      
	      while (loop) {
	         
	         System.out.print("λ μκ³ νμκ² μ΅λκΉ? [Y/N]: ");
	         String more = scan.nextLine();
	         System.out.println();
	         
	         if (more.equalsIgnoreCase("Y")){	               
	        	 productadd();
	        	 loop = false;
	         } else if (more.equalsIgnoreCase("N")) {
	            loop = false;
	         } else {  
	            System.err.println("π₯ μ¬λ°λ₯΄κ² μλ ₯ν΄μ£ΌμΈμ. π₯");
	            System.out.println();
	         }
	         
	      }
	      
	   }
	 
	 private static boolean isOverlap(String ProductName) throws Exception {		
			load();
		 	
			String str="";
			
			for(Product p : list) {
				str += p.getProductName()+",";
			}		
			
			String[] temp = str.split(",");
			
			for(int i=0;i<temp.length;i++) {
				if(ProductName.equals(temp[i])) {
					return true;
				}
			}

			list.clear();
			
			return false;
			
			
			
		}
	 
	 private static void load() throws Exception {
			
			BufferedReader reader = new BufferedReader(new FileReader(Path.PRODUCTDIR));
			
			String line = null;
			
			while ((line = reader.readLine()) != null) {
				//1νμ  > λ©€λ² 1λͺ > Member κ°μ²΄ 1κ° μμ±
				
				String[] temp = line.split(",");
				
				Product p = new Product();

				p.setSeq(temp[0]);
				p.setProductName(temp[1]);
				p.setCategory(temp[2]);
				p.setManufacturer(temp[3]);
				p.setSubstitute(temp[4]);
				p.setVeg(temp[5]);
				p.setMinor(temp[6]);
				p.setProductCount(temp[7]);
				p.setProductPrice(temp[8]);
				
				list.add(p);
				
			}
			
			reader.close();
			
		}
}//μ¬κ³ κ΄λ¦¬


