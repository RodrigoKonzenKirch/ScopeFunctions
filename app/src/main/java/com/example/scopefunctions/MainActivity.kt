package com.example.scopefunctions

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.scopefunctions.ui.theme.ScopeFunctionsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        scopeFunctions()
        setContent {
            ScopeFunctionsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MainScreen()
                }
            }
        }
    }
}

class Person(
    var name: String = "",
    var age: Int = 0,
    var address: String = ""
){
    fun increaseAge(){
        age++
    }
    fun doSomethingCool(){
        // Perform some awesome operations
    }
}

fun scopeFunctions(){

/*  Let

    Perform operation on non-nul object
    Return a new value
    Perform null check
    Only executes the code when object is not null
    Chain operation on non-null object
 */

    val result = "This scope function is called".let { it.uppercase() }.plus(" LET!")
    // result will print: THIS SCOPE FUNCTION IS CALLED LET!
    println(result)

    var nullableString: String? = null
//    nullableString = "a"
    nullableString?.let {
        // this code block will only executes when 'nullableString' is not null
        println(it)
    } ?: println("'nullableString' is null, do something.")

/*  Run

    Perform series of operations on non-null object
    Return the result
    Access properties and functions of the non-null object directly
 */

    val personOne = Person("Mike", 25, "Mike's home address")
    personOne.run{
        println("Printing obj with 'run'... Name: $name, Age: $age, Address: $address")
        age +5
    }

/*  With

    Access properties and functions of any object directly
    null and nun-null objects
 */
    val personTwo = Person("Ana", 25, "Ana's home address")
    with(personTwo){
        println("Printing obj with 'with'... Name: $name, Age: $age, Address: $address")
        increaseAge()
    }

/*  Apply

    Configure an object setting properties and calling functions
    Returns the modified object
    Initialize objects in a concise and readable way
*/

    val personThree = Person().apply {
        name= "Wang"
        age = 22
        address = "Wang's home address"
    }
    println("Printing obj with 'apply'... Name: ${personThree.name}, Age: ${personThree.age} , Address: ${personThree.address}")

/* Also

    Perform side effects on object (logging, debugging)
    Chain additional operations on the original object after performing side effects
*/

    val personFour = Person("Min", 30)
    personFour.also {
        println("Printing obj with 'also'... Name: ${it.name}, Age: ${it.age}")
    }.increaseAge()

}

@Composable
fun MainScreen() {
    Text(text = "Best Use Cases for Each Scope Function.")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ScopeFunctionsTheme {
        MainScreen()
    }
}