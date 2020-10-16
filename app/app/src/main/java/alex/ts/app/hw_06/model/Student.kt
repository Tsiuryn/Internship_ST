package alex.ts.app.hw_06.model

import java.io.Serializable
import java.util.*

data class Student(
    val uuid: UUID,
    var name: String,
    var surname: String): Serializable