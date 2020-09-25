package com.photographermembers;
//main
import java.util.Scanner;

public class PhotographerMembers {

    private static Scanner scan = new Scanner(System.in);
    private static MemberList memberList = new MemberList();

    public static void main(String[] args) {
        boolean quit = false;
        startSystem();
        printMenu();
        while (!quit) {
            System.out.println("\nChoose: (Number 6 to show alternatives)");
            int choice = scan.nextInt();
            scan.nextLine();

            switch (choice) {
                case 0:
                    System.out.println("\nShutting down system!...");
                    quit = true;
                    break;

                case 1:
                    memberList.printMember();
                    break;

                case 2:
                    addNewMember();
                    break;

                case 3:
                    updateMember();

                case 4:
                    removeMember();

                case 5:
                    queryMember();

                case 6:
                    printMenu();
                    break;
            }
        }
    }

    private static void addNewMember() {
        System.out.println("Please enter name of the member: ");
        String name = scan.nextLine();
        System.out.println("Please enter mobile number to the member: ");
        String mobilePhone = scan.nextLine();
        System.out.println("Please enter the brand of camera member has: ");
        String cameraBrand = scan.nextLine();
        System.out.println("Please enter the main genre for the member: ");
        String genre = scan.nextLine();
        Member newMember = new Member(name, mobilePhone, cameraBrand, genre);
        if (memberList.addNewMember(newMember)) {
            System.out.println("New contact added: Name: " + name + ", Mobile number: " + mobilePhone);
        } else {
            System.out.println("Can't add, " + name + " is already in the system.");
        }
    }

    private static void updateMember(){
        System.out.println("Enter name of member who's information you want to edit: ");
        String name = scan.nextLine();
        Member existingMembers = memberList.queryMember(name);
        if(existingMembers == null) {
            System.out.println("Member couldn't be found.");
            return;
        }

        System.out.println("Update name for the member: ");
        String newName = scan.nextLine();
        System.out.println("Update number for the member: ");
        String newMobileNumber = scan.nextLine();
        System.out.println("Update camera model for the member: ");
        String newCamera = scan.nextLine();
        System.out.println("Update genre");
        String newGenre = scan.nextLine();
        Member newMember = new Member(newName, newMobileNumber, newCamera, newGenre);
        if (memberList.updateMember(existingMembers, newMember)){
            System.out.println("Member information is now up to date.");
        } else {
            System.out.println("Couldn't update member information.");
        }
    }

    private static void removeMember() {
        System.out.println("Write the name of the member you'd like to remove: ");
        String name = scan.nextLine();
        Member existingMembers = memberList.queryMember(name);
        if (existingMembers == null) {
            System.out.println("Can't find member.");
            return;
        }
        if(memberList.removeMember(existingMembers)){
            System.out.println("Member has been removed.");
        } else {
            System.out.println("Can't remove member");
        }
    }

    private static void queryMember(){
        System.out.println("Write member's name: ");
        String name = scan.nextLine();
        Member existingMembers = memberList.queryMember(name);
        if (existingMembers == null) {
            System.out.println("Couldn't find member.");
            return;
        }
        System.out.println("Name: " + existingMembers.getName() + ". | Mobile Phone: "
                + existingMembers.getMobileNumber() + ". | Camera brand: " + existingMembers.getCameraBrand() +
                ". | Favourite genre: " + existingMembers.getGenre() + ". ");
    }

    private static void startSystem() {
        System.out.println("System's starting, welcome!");
    }
    private static void printMenu(){
        System.out.println("\nChoose:\n");
        System.out.println(
                "0 > Shut down the system\n" +
                "1 > Show member information\n" +
                "2 > Add new member\n" +
                "3 > Update a members information\n" +
                "4 > Delete an existing member\n" +
                "5 > Search for an existing member\n" +
                "6 > List all possible choices\n");

    }
}


