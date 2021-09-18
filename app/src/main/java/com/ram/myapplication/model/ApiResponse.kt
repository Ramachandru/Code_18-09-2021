package com.ram.myapplication.model

data class Repose(val id: Int, val node_id: String, val name: String, val full_name: String, val fork: Boolean,
                  val owner: Owner)

data class Owner(val login: String, val id: Int, val node_id: String, val url: String)
