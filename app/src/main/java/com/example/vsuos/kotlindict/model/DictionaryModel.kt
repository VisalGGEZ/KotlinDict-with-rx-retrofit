package com.example.vsuos.kotlindict.model

import com.google.gson.annotations.SerializedName

/**
 * Created by v.suos on 10/3/2017.
 */
data class DictionaryModel(@SerializedName("sourceDictionary") var sourceDictionary: String? = "",
                           @SerializedName("word") var word: String? = "",
                           @SerializedName("partOfSpeech") var partOfSpeech: String? = "",
                           @SerializedName("attributionText") var attributionText: String? = "",
                           @SerializedName("sequence") var sequence: String? = "",
                           @SerializedName("text") var text: String? = "",
                           @SerializedName("score") var score: Int = 0) {}
