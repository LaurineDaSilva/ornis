package co.simplon.ornis.entities;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

// Package visible class (only this package)
@MappedSuperclass
abstract class AbstractEntity {
    // Package (default) visible = no keyword
    // (vs public, private, protected)

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    AbstractEntity() { // Package (default) visible
	// Required no-arg constructor
    }

    public Long getId() {
	return id;
    }

    @SuppressWarnings("unused")
    private void setId(Long id) {
	// Prevents from accidental assignment (set by DB)
	this.id = id;
    }
}
