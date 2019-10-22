package edu.towson.cosc412.seyoum.workout

class HomeFeed(val next: String, val results: List<Workout>)

class Workout(val id: Int, val description: String, val name: String, val category: Int)