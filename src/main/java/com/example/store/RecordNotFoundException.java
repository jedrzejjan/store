package com.example.store;

public class RecordNotFoundException extends RuntimeException {
    public RecordNotFoundException(Long id) {
        super("Could't find record " + id);
    }
}
