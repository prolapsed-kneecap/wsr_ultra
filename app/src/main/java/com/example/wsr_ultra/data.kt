package com.example.wsr_ultra

object data {

    val images = mutableMapOf(
        0 to "11:00",
        1 to "15:55",
        2 to "19:11",
        3 to "11:11",
        4 to ""
    )

    val imageDrawables = mutableListOf<Int>(
        R.drawable.image01,
        R.drawable.image02,
        R.drawable.image03,
        R.drawable.image04,
        R.drawable.image1,
        R.drawable.image2,
        R.drawable.image3,
        R.drawable.image4,
    )

    var currentDeleted = 0

    val feelings = mutableListOf<Pair<String, Int>>(
        "Спокойным" to R.drawable.vector,
        "Расслабленным" to R.drawable.relax,
        "Сосредоточенным" to R.drawable.vector1,
        "Взовлнованным" to R.drawable.anxious,
        "Что-то ещё" to R.drawable.vector
    )
    val blocks = mutableListOf<Pair<String, String>>(
        "Заголовок блока" to "Краткое описание \n блока с двумя строчками",
        "Заголовок блока" to "Краткое описание блока \n с двумя строчками"
    )
    val descToImage = mutableMapOf(
        "Краткое описание \n блока с двумя строчками" to R.drawable.blockimage1,
        "Краткое описание блока \n с двумя строчками" to R.drawable.blockimage2
    )
}