package com.example.AddressBook;

import java.io.IOException;


import org.springframework.ui.Model;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AddressBookController {

    @Autowired
    private BuddyInfoRepository buddyInfoRepository;

    @Autowired
    private AddressBookRepository addressBookRepository;

    @Autowired
    public AddressBookController(AddressBookRepository addressBookRepository, BuddyInfoRepository buddyInfoRepository) {
        this.addressBookRepository = addressBookRepository;
        this.buddyInfoRepository = buddyInfoRepository;
    }

    @GetMapping("/Landing")
    public String Landing(Model model) {
        model.addAttribute("addressBook", new AddressBook());
        model.addAttribute("buddyInfo", new BuddyInfo());
        return "Landing";
    }

    @RequestMapping("/")
    public void redirect(HttpServletResponse response) throws IOException {
        response.sendRedirect("/Landing");
    }


    @PostMapping("/NewAddressBook")
    public String addressBook(Model model){
        if (addressBookRepository.findById(1L) == null){
            addressBookRepository.save(new AddressBook());
        }
        AddressBook addressBook = addressBookRepository.findById(1L);
        model.addAttribute("addressBook", addressBook);
        return "addressBook";
    }

    @PostMapping("/addBuddyInfo")
    public String addBuddy(@ModelAttribute("buddyInfo") BuddyInfo buddyInfo) {
        AddressBook addressBook = addressBookRepository.findById(1L);
        addressBook.addBuddy(buddyInfo);
        buddyInfoRepository.save(buddyInfo);
        addressBookRepository.save(addressBook);
        return "buddyInfo";
    }

    @DeleteMapping("/AddressBook/{id}")
    void deleteEmployee(@PathVariable Long id) {
         buddyInfoRepository.deleteById(id);
        }

}
