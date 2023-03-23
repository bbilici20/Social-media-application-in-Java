/* Pledge of Honor *************************************************************************************
I hereby certify that I have completed this programming project on my own without any help from anyone else. The effort in the project thus belongs completely to me. I did not search for a solution, or I did not consult to any program written by others or did not copy any program from other sources. I read and followed the guidelines provided in the project description.
READ AND SIGN BY WRITING YOUR NAME SURNAME AND STUDENT ID
SIGNATURE: <Beril Bilici, 75794>
************************************************************************************************************/

package myProj;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JFrame;

public class TestGUI {
	public static void main(String[] args) {
		
		//12 users
		
		User user1 = new User("Kevin","Grace","Kevin07","27","kevingrace@email.com","123456a");
		User user2 = new User("Mikayla","Hurt","Mikayla09","21","mikaylahurt@email.com","123456a");
		User user3 = new User("Baker","Browser","Baker85","23","bakerbrowser@email.com","123456a");
		User user4 = new User("Tisha","Chatman","Tisha58","35","tishachatman@email.com","123456a");
		User user5 = new User("Ace","Fuentes","Ace01","30","acefuentes@email.com","123456a");
		User user6 = new User("Audrey","Stone","Audrey05","30","audreystone@email.com","123456a");
		User user7 = new User("Ramell","Nolan","Ramell02","37","ramellnolan@email.com","123456a");
		User user8 = new User("Ivana","Schneider","Ivana05","40","ývanaschneider@email.com","123456a");
		User user9 = new User("Terry","Stowell","Terry13","33","terrystowell@email.com","123456a");
		User user10 = new User("Penelope","Draper","Penny43","28","penelopedraper@email.com","123456a");
		User user11 = new User("Andrew", "Cleese","Andy78","35","andrewcleese@email.com","123456a");
		User user12 = new User("Elin","Magnusson","Elly98","25","elinmagnusson@email.com","123456a");
		
		user1.followUser(user2);user1.followUser(user3);user1.followUser(user4);
		user2.followUser(user3);user2.followUser(user4);user2.followUser(user5);
		user3.followUser(user4);user3.followUser(user5);user3.followUser(user6);
		user4.followUser(user5);user4.followUser(user6);user4.followUser(user7);
		user5.followUser(user6);user5.followUser(user7);user5.followUser(user8);
		user6.followUser(user7);user6.followUser(user8);user6.followUser(user9);
		user7.followUser(user8);user7.followUser(user9);user7.followUser(user10);
		user8.followUser(user9);user8.followUser(user10);user8.followUser(user11);
		user9.followUser(user10);user9.followUser(user11);user9.followUser(user12);
		user10.followUser(user11);user10.followUser(user12);user10.followUser(user1);
		user11.followUser(user12);user11.followUser(user1);user11.followUser(user2);
		user12.followUser(user1);user12.followUser(user2);user12.followUser(user3);
		
		
		
		user1.setPremium();
		user7.setPremium();
		user10.setPremium();
		user4.setPremium();
		
		User.getUsers().add(user1); user1.setProfilePhoto("C:\\Users\\beril\\Downloads\\1.png");
		User.getUsers().add(user2);user2.setProfilePhoto("C:\\Users\\beril\\Downloads\\a-cat-playing-in-a-yard-in-beijing-china.jpg");
		User.getUsers().add(user3);user3.setProfilePhoto("C:\\Users\\beril\\Downloads\\carr.jfif");
		User.getUsers().add(user4);user4.setProfilePhoto("C:\\Users\\beril\\Downloads\\defaultProfile.jfif");
		User.getUsers().add(user5);user5.setProfilePhoto("C:\\Users\\beril\\Downloads\\defaultProfile.jfif");
		User.getUsers().add(user6);user6.setProfilePhoto("C:\\Users\\beril\\Downloads\\defaultProfile.jfif");
		User.getUsers().add(user7);user7.setProfilePhoto("C:\\Users\\beril\\Downloads\\defaultProfile.jfif");
		User.getUsers().add(user8);user8.setProfilePhoto("C:\\Users\\beril\\Downloads\\defaultProfile.jfif");
		User.getUsers().add(user9);user9.setProfilePhoto("C:\\Users\\beril\\Downloads\\defaultProfile.jfif");
		User.getUsers().add(user10);user10.setProfilePhoto("C:\\Users\\beril\\Downloads\\defaultProfile.jfif");
		User.getUsers().add(user11);user11.setProfilePhoto("C:\\Users\\beril\\Downloads\\defaultProfile.jfif");
		User.getUsers().add(user12);user12.setProfilePhoto("C:\\Users\\beril\\Downloads\\defaultProfile.jfif");
		
		Content content1 = new Content(user1,"Square","This is a new square","C:\\Users\\beril\\Desktop\\comp132 proje resimler\\Square-logo.png");
		Content content2 = new Content(user2,"Circle", "I drew a circle","C:\\Users\\beril\\Desktop\\comp132 proje resimler\\768px-Circle_-_black_simple.svg.png");
		Content content3 = new Content(user3,"Cat","This is my cat","C:\\Users\\beril\\Desktop\\comp132 proje resimler\\indir.jfif");
		Content content4 = new Content(user4,"Dog","This is my dog","C:\\Users\\beril\\Desktop\\comp132 proje resimler\\KOA_Nassau_2697x1517.jpg");
		Content content5 = new Content(user5,"Telephone","My new telephone","C:\\Users\\beril\\Desktop\\comp132 proje resimler\\ast-1430025.png.pub.png");
		Content content6 = new Content(user6,"Quote","","C:\\Users\\beril\\Desktop\\comp132 proje resimler\\indir (1).jfif");
		Content content7= new Content(user7,"What is this?","","C:\\Users\\beril\\Desktop\\comp132 proje resimler\\indir (2).jfif");
		Content content8 = new Content(user8,"I missed school","Do you miss your school too?","C:\\Users\\beril\\Desktop\\comp132 proje resimler\\1543250046244.jfif");
		Content content9 = new Content(user9,"Pasta Puttanesca","","C:\\Users\\beril\\Desktop\\comp132 proje resimler\\__opt__aboutcom__coeus__resources__content_migration__simply_recipes__uploads__2013__02__pasta-puttanesca-fork-horiz-1600-aeb7e018a32b4bc2ae85ea893cabdb40.jpg");
		Content content10 = new Content(user10,"Birthday party","I made a cake for my sister's birthday party","C:\\Users\\beril\\Desktop\\comp132 proje resimler\\kestaneli-yas-pasta-87f9de18-f137-41fe-aaf2-7eac8939cae4.jpg");
		Content content11= new Content(user11,"New dress","Guys should I buy this, I can't decide.","C:\\Users\\beril\\Desktop\\comp132 proje resimler\61YXZmuiJsL._AC_UY550_.jpg");
		Content content12= new Content(user12,"Viral math question","","C:\\Users\\beril\\Desktop\\comp132 proje resimler\5a4bdcc6cb9df434008b4577.webp");
		
		Content content13= new Content(user1,"Hello everyone","I hope everyone is having a good day",null);
		Content content14= new Content(user1,"School","I go to school at 8.",null);
		Content content15= new Content(user1,"Pizza","I don't like pizza that much.",null);
		
		Content content16= new Content(user2,"Computer","My computer is broken",null);
		Content content17= new Content(user2,"White","My favorite color is white",null);
		Content content18= new Content(user2,"Great","It is a great day today",null);
		
		Content content19= new Content(user3,"Shoes","Do you know anywhere I can buy shoes?",null);
		Content content20= new Content(user3,"Night","Nights in Istanbul are a bit cold",null);
		Content content21= new Content(user3,"Hello","Good evening everyone!",null);
		
		Content content22= new Content(user4,"Good","Good vibes",null);
		Content content23= new Content(user4,"Physics","Physics is hard",null);
		Content content24= new Content(user4,"Hello!","Good afternoon everyone!",null);
		
		Content content25= new Content(user5,"Counting","3,2,1...",null);
		Content content26= new Content(user5,"Water","Drink 2 liters a day",null);
		Content content27= new Content(user5,"New Youtuber","I found a new Youtube channel named A",null);
		
		Content content28= new Content(user6,"Orange juice","Orange juice is tasty",null);
		Content content29= new Content(user6,"Coffee","Coffee is bitter",null);
		Content content30= new Content(user6,"New backpack","I bought a new backpack but it is ripped",null);
		
		Content content31= new Content(user7,"Problem","Can anyone help me?",null);
		Content content32= new Content(user7,"Sunny","Today is sunny",null);
		Content content33= new Content(user7,"Sleepy","I am gonna sleep. Goodnight!",null);
		
		Content content34= new Content(user8,"Cats","I love cats!",null);
		Content content35= new Content(user8,"Work","I work 5 hours a day.",null);
		Content content36= new Content(user8,"Game","I'm playing a game right now. Join me!",null);
		
		Content content37= new Content(user9,"Busy","I'm driving, busy!",null);
		Content content38= new Content(user9,"Coffee at work","Coffee at work is tasteless :(",null);
		Content content39= new Content(user9,"Sorry","Sorry for leaving early",null);
		
		Content content40= new Content(user10,"Ooo","Wow!",null);
		Content content41= new Content(user10,"Rolling","Rolling on the floor makes my back hurt",null);
		Content content42= new Content(user10,"Nice!","Today I saw a nice painting!",null);
		
		Content content43= new Content(user11,"Bears","Bears are scary",null);
		Content content44= new Content(user11,"News","I don't watch the news anymore",null);
		Content content45= new Content(user11,"Eggs","Eggs are mostly eaten on breakfast",null);
		
		Content content46= new Content(user12,"Salad","Eat a lot of salad",null);
		Content content47= new Content(user12,"Tuna","I like eating tunafish",null);
		Content content48= new Content(user12,"Forgot","Guys I forgot my keys at home",null);
		
		
		ArrayList<User> list1 = new ArrayList<User>();
		list1.add(user1); list1.add(user2); list1.add(user3); 
		
		ArrayList<User> list2 = new ArrayList<User>();
		list2.add(user4); list2.add(user5); list2.add(user6); 
		
		ArrayList<User> list3 = new ArrayList<User>();
		list3.add(user7); list3.add(user8); list3.add(user9); 
		
		ArrayList<User> list4 = new ArrayList<User>();
		list4.add(user10); list4.add(user11); list4.add(user12); 
		
		Group group1 = new Group(user1,list1,"Group1","Swimming, cooking","Thailand");
		Group group2 = new Group(user4,list2,"Group2","Fishing, sewing","Canada");
		Group group3 = new Group(user7,list3,"Group3","Basketball, piano","Finland");
		Group group4 = new Group(user10,list4,"Group4","Dancing, music","Italy");
		
		
		content1.addContenttoUser();
		content2.addContenttoUser();
		content3.addContenttoUser();
		content4.addContenttoUser();
		content5.addContenttoUser();
		content6.addContenttoUser();
		content7.addContenttoUser();
		content8.addContenttoUser();
		content9.addContenttoUser();
		content10.addContenttoUser();
		content11.addContenttoUser();
		content12.addContenttoUser();
		
		content13.addContenttoGroup(group1);
		content14.addContenttoUser();
		content15.addContenttoGroup(group1);
		
		content16.addContenttoGroup(group1);
		content17.addContenttoUser();
		content18.addContenttoGroup(group1);
		
		content19.addContenttoGroup(group1);
		content20.addContenttoUser();
		content21.addContenttoGroup(group1);
		
		content22.addContenttoGroup(group2);
		content23.addContenttoUser();
		content24.addContenttoGroup(group2);
		
		content25.addContenttoGroup(group2);
		content26.addContenttoUser();
		content27.addContenttoGroup(group2);
		
		content28.addContenttoGroup(group2);
		content29.addContenttoUser();
		content30.addContenttoGroup(group2);
		
		content31.addContenttoGroup(group3);
		content32.addContenttoUser();
		content33.addContenttoGroup(group3);
		
		content34.addContenttoGroup(group3);
		content35.addContenttoUser();
		content36.addContenttoGroup(group3);
		
		content37.addContenttoGroup(group3);
		content38.addContenttoUser();
		content39.addContenttoGroup(group3);
		
		content40.addContenttoGroup(group4);
		content41.addContenttoUser();
		content42.addContenttoGroup(group4);
		
		content43.addContenttoGroup(group4);
		content44.addContenttoUser();
		content45.addContenttoGroup(group4);
		
		content46.addContenttoGroup(group4);
		content47.addContenttoUser();
		content48.addContenttoGroup(group4);
		
				FirstPage myframe = new FirstPage();
				
				myframe.setSize(550,700);
				myframe.setVisible(true);
				myframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
			}
}
