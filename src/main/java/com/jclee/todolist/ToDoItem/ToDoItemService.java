package com.jclee.todolist.ToDoItem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ToDoItemService {
    @Autowired
    private ToDoItemRepository toDoItemRepository;

    public ToDoItem get(final String id) {
// do id validation
        return toDoItemRepository.findById(id).orElse(null);
    }

    public ToDoItem create(final ToDoItem toDoItem) {
        if(toDoItem == null) {
            throw new NullPointerException("To Do Item cannot be null.");
        }
        return toDoItemRepository.insert(toDoItem);
    }

    public List<ToDoItem> getAll() {
        return toDoItemRepository.findAll();
    }
}
