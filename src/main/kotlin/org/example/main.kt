package org.example

import org.json.JSONArray
import org.json.JSONObject
import java.net.URL



fun main()
{
    val apiResponse = URL("https://typeahead.target.com/autocomplete/TypeAheadSearch/v2?q=cereal").readText()
    JsonDataPrint(apiResponse.toString())
}

fun JsonDataPrint(string: String)
{
    val obj = JSONObject(string)
    for(i in obj.keys())
    {
        val str = obj.getJSONArray(i)
        println("$i :: ")
        val jsonArray = JSONArray(str.toString())
        for (j in 0 until jsonArray.length())
        {
            val json = jsonArray.getJSONObject(j)
            val keys = json.keys()
            while (keys.hasNext())
            {
                val key = keys.next()
                try
                {
                    val a1 = JSONArray(json[key].toString())
                    printarray(a1.toString())
                }
                catch(e: Exception)
                {
                    println("           " + key + ":" + json[key])
                }
            }
        }
    }
}

fun printarray(arr:String) {
    val JSONArray = JSONArray(arr)
    for (j in 0 until JSONArray.length()) {
        val json = JSONArray.getJSONObject(j)
        val keys = json.keys()
        while (keys.hasNext()) {
            val key = keys.next()
            println("                       " + key + ":" + json[key])
        }

    }
}