package com.example.AddressBook;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name="AddressBook")
public class AddressBook {


    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    public Collection<BuddyInfo> buddyInfoList;

    @Id
    @GeneratedValue
    private Integer id = null;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public AddressBook() {
        buddyInfoList = new ArrayList<>();
    }

    public Collection<BuddyInfo> getBuddy(){
        return buddyInfoList;
    }

    public void setBuddy(Collection<BuddyInfo> buddyInfoList){
        this.buddyInfoList = buddyInfoList;
    }


    public void addBuddy(BuddyInfo buddyInfo){
        if (buddyInfo != null){
            buddyInfoList.add(buddyInfo);
        }
    }

    public static void main(String[] args) {
        AddressBook addressBook = new AddressBook();
        BuddyInfo buddy1 = new BuddyInfo("Jamil", "123 HollyWood Blv", "613-123-4567");
        BuddyInfo buddy2 = new BuddyInfo("John", "124 HollyWood Blv", "613-123-4567");
        BuddyInfo buddy3 = new BuddyInfo("Jackson", "125 HollyWood Blv", "613-123-4567");

        addressBook.addBuddy(buddy1);
        addressBook.addBuddy(buddy2);
        addressBook.addBuddy(buddy3);


    }


}
