package edu.towson.cosc412.seyoum.workout

class ImageFeed(val next: String, val results: List<Images>)

class Images(val id: Int, val image: String, val exercise: Int)