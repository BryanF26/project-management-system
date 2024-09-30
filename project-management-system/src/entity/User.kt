package entity

import enum.Roles

class User(
    var id: Int,
    var name: String,
    var role: Roles
) {
    init {
        if (name.isBlank()) throw IllegalArgumentException("Name cannot be blank")
    }
}