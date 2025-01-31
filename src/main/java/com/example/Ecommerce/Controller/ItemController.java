package com.example.Ecommerce.Controller;

import com.example.Ecommerce.Models.Item;
import com.example.Ecommerce.Repositories.ItemRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/items")
public class ItemController {

    private final ItemRepository itemRepository;

    public ItemController(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    // Retrieve all items
    @GetMapping
    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    // Retrieve a specific item by ID
    @GetMapping("/{id}")
    public Item getItemById(@PathVariable Integer id) {
        return itemRepository.findById(id).orElseThrow(() -> new RuntimeException("Item not found"));
    }

    // Create a new item
    @PostMapping
    public void createItem(@RequestBody Item item) {
        itemRepository.save(item);
    }

    // Update an item
    @PutMapping("/{id}")
    public void updateItem(@PathVariable Integer id, @RequestBody Item itemDetails) {
        Item item = itemRepository.findById(id).orElseThrow(() -> new RuntimeException("Item not found"));
        item.setName(itemDetails.getName());
        item.setDescription(itemDetails.getDescription());
        itemRepository.save(item);
    }

    // Delete an item
    @DeleteMapping("/{id}")
    public void deleteItem(@PathVariable Integer id) {
        itemRepository.deleteById(id);
    }
}
