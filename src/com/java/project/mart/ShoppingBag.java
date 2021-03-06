package com.java.project.mart;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Set;

public class ShoppingBag {
	private static Scanner scan;
	public static HashMap<Integer, Integer> map = new HashMap<>();

	private static String dir = Path.PRODUCTDIR;
	// private static String dir = Path.PRODIR;
	public static ArrayList<Product> list;

	static {
		scan = new Scanner(System.in);
		map = new HashMap<Integer, Integer>(); // μ₯λ°κ΅¬λ
		list = new ArrayList<Product>();

	}

	public static void run() {

		int inputShopBag = 0;
		load();
		int inputShopBagCount = 0;
		int size = Integer.parseInt(list.get(list.size() - 1).getSeq());
		int count = 0;
		String minor = "";
		String name = "";
		String veg = "";
		System.out.println();
		System.out.println();

		System.out.println();
		System.out.println("πμ₯λ°κ΅¬λμ λ΄μ μνμ λ²νΈλ₯Ό μλ ₯ν΄μ£ΌμΈμ.π");
		System.out.println();
		System.out.println("μ ν¨ν μν λ²νΈ : 1 ~ " + size);
		System.out.println();

		System.out.print("μλ ₯: ");// seq

		while (true) {
			try {
				inputShopBag = scan.nextInt();
				System.out.println(
						"ββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββ");

				if (inputShopBag <= size) {

					count = Integer.parseInt(list.get(inputShopBag - 1).getProductCount());
					name = list.get(inputShopBag - 1).getProductName();
					minor = list.get(inputShopBag - 1).getMinor();
					veg = list.get(inputShopBag - 1).getVeg();

					System.out.println();
					System.out.println("μνλͺ: " + name);
					System.out.println("μνμ μ¬κ³ : " + count);
					System.out.println();

					if (count == 0) {

						System.out.println(
								"ββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββ");
						System.out.println();
						System.out.println("π₯ν΄λΉ μνμ νμ μλλ€.π₯");
						System.out.println("π₯λ€λ₯Έ μνμ κ΅¬λ§€ν΄μ£ΌμΈμ.π₯");
						System.out.println();
						System.out.println(
								"ββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββ");
						run();
					} else if (minor.equalsIgnoreCase("F")) {
						try {
							BufferedReader reader = new BufferedReader(new FileReader(Path.MEMBERDIR));
							String line = null;
							while ((line = reader.readLine()) != null) {
								if (MainFrame.loginId.equals(line.split(",")[0])) {
									int age = Integer.parseInt(line.split(",")[3]);

									if (age >= 20) {
										// line =null;

										break;
									} else if (age < 20) {
										System.out.println("λ―Έμ±λμ κ΅¬λ§€λΆκ° μνμλλ€.");
										run();
									}
								}
							}
							reader.close();

						} catch (IOException e) {
							e.printStackTrace();
						}
					}
					try {
						BufferedReader reader = new BufferedReader(new FileReader(Path.MEMBERDIR));
						String line = null;
						while ((line = reader.readLine()) != null) {
							if (MainFrame.loginId.equals(line.split(",")[0])) {
								int vegOption = Integer.parseInt(veg);
								int memveg = Integer.parseInt(line.split(",")[6]);
								if (memveg > vegOption) {
									System.out.println("νμ μ λ³΄μ λ² μ§νλ¦¬μΈ μ΅μμ νμΈν΄μ£ΌμΈμ.");
									vegmenu();
									System.out.println("μ₯λ°κ΅¬λμ λ΄κΈΈ μνμμ§ μμΌλ©΄ μλμ '0'μ μλ ₯ν΄μ£ΌμΈμ.");
									System.out.println(
											"ββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββ");

								}
							}
						}
						reader.close();
					} catch (Exception e1) {
						e1.printStackTrace();
					}

					System.out.println("πμ₯λ°κ΅¬λμ λ΄μ μνμ μλμ μλ ₯ν΄μ£ΌμΈμ.π\r\n");
					System.out.println("πμλμ κ΅¬λ§€νμκ³  μΆμΌμ  λ§νΌ μλ ₯ν΄μ£ΌμΈμ.π\r\n");
					System.out.print("μλ ₯: ");// μλ

					while (true) {
						try {
							inputShopBagCount = scan.nextInt();
							System.out.println(
									"ββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββ");
							break;
						} catch (InputMismatchException ime) {
							// scan.close();
							scan = new Scanner(System.in);
							System.out.println(
									"ββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββ");
							System.out.println("π₯μλͺ»λ μλ μλ ₯μλλ€.π₯");
							System.out.println("π₯μ«μλ§ μλ ₯νμΈμ.π₯");
							System.out.print("μλ ₯: ");

						}
					}

					if (inputShopBagCount <= count) {
						try {
							bagList(inputShopBag, inputShopBagCount);
						} catch (Exception e) {
							e.printStackTrace();
						}
					} else {
						System.out.println(
								"ββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββ");
						System.out.println("\r\nπ₯μλͺ»λ μλμλ ₯μλλ€.π₯\r\nπ₯λ€μ μλν΄μ£ΌμΈμ.π₯\r\n");
						System.out.println(
								"ββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββ");
						run();
					}
				} else {
					System.out.println(
							"ββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββ");
					System.out.println("\r\nπ₯μλͺ»λ μν λ²νΈμλλ€.π₯\r\nπ₯λ€μ μλν΄μ£ΌμΈμ.π₯\r\n");
					System.out.println(
							"ββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββ");
					run();
				}
				// >κ²°μ : μλλ§νΌ λλ―Έλ°μ΄ν°μμ λΉΌκΈ°
			} catch (InputMismatchException ime) {
				// scan.close();
				scan = new Scanner(System.in);
				System.out.println(
						"ββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββ");
				System.out.println("\r\nπ₯μλͺ»λ μν λ²νΈ μλ ₯μλλ€.π₯");
				System.out.println("π₯μ«μλ§ μλ ₯νμΈμ.π₯\r\n");
				System.out.print("μλ ₯: ");
			} catch (IndexOutOfBoundsException iobe) {

				scan = new Scanner(System.in);
				System.out.println(
						"ββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββ");
				System.out.println("\r\nπ₯μλͺ»λ μν λ²νΈ μλ ₯μλλ€.π₯");
				System.out.println("πμ ν¨ν μν λ²νΈλ₯Ό μλ ₯ν΄μ£ΌμΈμ.π\r\n");
				System.out.println("μ ν¨ν μν λ²νΈ : 1 ~ " + size);
				System.out.print("μλ ₯: ");

			}
		}

	}

	private static void vegmenu() {
		System.out.println("ββββββββββββββββββββββββββββββββββββββββββββββββββββ");
		System.out.println("πΏμ°Έκ³ ν΄μ£ΌμΈμ!πΏ");
		System.out.println("β νλ μνλ¦¬μΈ(π?   π·   π   π    π³   πΌ   π   πΏ)");
		System.out.println("β‘ν΄λ‘-νμ€μ½ ( π   π    π³   πΌ   π   πΏ)");
		System.out.println("β’νμ€μ½ ( π    π³   πΌ   π   πΏ)");
		System.out.println("β£λ½ν -μ€λ³΄ ( π³   πΌ   π   πΏ)");
		System.out.println("β€μ€λ³΄( π³    π   πΏ)");
		System.out.println("β₯λ½ν ( πΌ   π   πΏ)");
		System.out.println("β¦λΉκ±΄( π   πΏ)");
		System.out.println("β§νλ‘νλ¦¬μΈ( π)");
		System.out.println("βββββββββββββββββββββββββββββββββββββββββββββββββββββ");
		System.out.println();

	}

	private static void load() {
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(dir));
			String line = null;

			while ((line = reader.readLine()) != null) {
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

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void bagList(int inputShopBag, int inputShopBagCount) throws Exception {

		map.put(inputShopBag, inputShopBagCount);
		System.out.println("\r\nπκ³μν΄μ μλ ₯νμκ² μ΅λκΉ?π");
		System.out.println();
		System.out.println("βββββββββββββββββ\r\n" + " 1. κ³μ μλ ₯\r\n" + " 2. μ₯λ°κ΅¬λ μΆλ ₯\r\n" + " 3. μ₯λ°κ΅¬λ κ΅¬λ§€\r\n"
				+ " 0. μ΄κΈ°νλ©΄\r\n" + "βββββββββββββββββ\r\n" + "γγα± α± ||\r\n" + "γ ( ο½₯Οο½₯ ||\r\n" + "γ /γγ€Ξ¦");
		System.out.println();
		System.out.print("μλ ₯: ");
		try {
			int answer = scan.nextInt();
			if (answer == 1) {
				// μ¬κ·νΈμΆ
				run();
			} else if (answer == 2) {
				// μ₯λ°κ΅¬λ λͺ©λ‘ μΆλ ₯
				Set<Integer> keySet = map.keySet();
				if (!map.isEmpty()) {
					if (map.get(inputShopBag) == 0) {
						map.remove(inputShopBag);
					}
				}

				System.out.println("β­ββββββββββββββββββββββββββ?\r\n");
				System.out.println("πμ₯λ°κ΅¬λ μΆλ ₯π\r\n");
				// key ==seq, seq λλ²λ‘ κ° λΆλ¬μ€κΈ°!?
				String line = null;
				// κ°μ΄ 0μ΄λ©΄ μ­μ ν΄μ£ΌκΈ°
				try {
					BufferedReader reader = new BufferedReader(new FileReader(dir));
					while ((line = reader.readLine()) != null) {
						for (Integer key : keySet) {
							String[] temp = line.split(",");
							String[] temp2 = temp[4].split("β ");
							String strkey = key + "";
							if (temp[0].equals(strkey)) {

								System.out.println(temp[0] + "." + temp[1] + ":" + map.get(key) + "κ°");

							}
						}
					}
					reader.close();
				} catch (Exception e) {
					e.printStackTrace();
				}

				System.out.println("β°ββββββββββββββββββββββββββ―");
				bagList(inputShopBag, inputShopBagCount);
				// answerCheck();

			} else if (answer == 0) {

				MemberMainFrame.run(MainFrame.loginId);

			} else if (answer == 3) {
				ProductBuy.run();
			}

		} catch (InputMismatchException ime) {
			System.out.println(
					"ββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββ");

			System.out.println("\r\nπ₯μλͺ»λ μλ ₯μλλ€! λ€μ μλν΄μ£ΌμΈμπ₯\r\n");

			System.out.println(
					"ββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββ");
			scan = new Scanner(System.in);
			bagList(inputShopBag, inputShopBagCount);
		}

	}

	private static void answerCheck() throws Exception {

		System.out.println("ββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββ");

		System.out.println("\r\nπκ³μν΄μ μλ ₯νμκ² μ΅λκΉ?π");
		System.out.println();
		System.out.println("0. μ΄κΈ°νλ©΄");
		System.out.println("1. κ³μ μλ ₯");
		System.out.println("2. μ₯λ°κ΅¬λ μΆλ ₯");
		System.out.println("3. μ₯λ°κ΅¬λ κ΅¬λ§€");
		System.out.println();
		System.out.print("μλ ₯: ");
		int baganswer = scan.nextInt();
		System.out.println("ββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββ");

		if (baganswer == 1) {

			try {
				run();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (baganswer == 2) {

		} else if (baganswer == 3) {

			ProductBuy.run();

		} else if (baganswer == 0) {

			// μ΄κΈ°νλ©΄
			MemberMainFrame.run(MainFrame.loginId);
		} else {
			System.out.println(
					"ββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββ");

			System.out.println("π₯μλͺ»λ μλ ₯μλλ€! λ€μ μλν΄μ£ΌμΈμπ₯");
			System.out.println(
					"ββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββββ");

			answerCheck();
		}

	}

}