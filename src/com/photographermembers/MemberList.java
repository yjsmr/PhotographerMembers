package com.photographermembers;
//controller
import java.util.ArrayList;

public class MemberList {
    private String aNumber;
    private ArrayList<Member> memberContact;

    //construct
    public MemberList() {
        this.aNumber = aNumber;
        this.memberContact = new ArrayList<Member>();
    }

    public boolean addNewMember(Member member) {
        if(contactFound(member.getName()) >=0){
            System.out.println("This contact already exists in the system");
            return false;
        }
        memberContact.add(member);
        return true;
    }

    public boolean updateMember(Member existingMember, Member newMember) {
        int positionTrue = contactFound(existingMember);
        if (positionTrue <0){
            System.out.println(existingMember.getName() + " couldn't be found.");
            return false;
        }
        this.memberContact.set(positionTrue, newMember);
        System.out.println(existingMember.getName() + " information has been updated" + newMember.getName());
        return false;

    }

    public boolean removeMember(Member member) {
        int positionTrue = contactFound(member);
        if(positionTrue <0){
            System.out.println(member.getName() + " couldn't be found.");
            return false;
        }
        this.memberContact.remove(positionTrue);
        System.out.println(member.getName() + " has been removed");
        return true;
    }

    private int contactFound(Member member) {
        return this.memberContact.indexOf(member);
    }
    private int contactFound(String memberName){
        for(int i=0; i<this.memberContact.size(); i++){
            Member member =this.memberContact.get(i);
            if(member.getName().equals(memberName)){
                return i;
            }
        }
        return -1;
    }

    public String queryMember(Member member) {
        if(contactFound(member) >=0){
            return member.getName();
        }
        return null;
    }

    public Member queryMember(String name){
        int position = contactFound(name);
        if(position >= 0) {
            return this.memberContact.get(position);
        }
        return null;
    }

    public void printMember() {
        System.out.println("Member list: ");
        for (int i=0; i<this.memberContact.size(); i++){
            System.out.println((i+1) + " " +
                    this.memberContact.get(i).getName() + " --> Mobile number: " +
                    this.memberContact.get(i).getMobileNumber() + ". | Camera brand: " +
                    this.memberContact.get(i).getCameraBrand() + ". | Type of genre: " +
                    this.memberContact.get(i).getGenre() + ".");
        }
    }
}
