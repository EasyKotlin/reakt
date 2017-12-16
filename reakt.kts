import java.io.File
import java.io.FileFilter

val srcPath = File("./front/dist/")

val templatesPath = "src/main/resources/templates/"
val jsFile = "src/main/resources/static/js/"
val cssPath = "src/main/resources/static/css/"

val templatesDir = File("src/main/resources/templates/")
val cssDir = File("src/main/resources/static/css/")
val jsDir = File("src/main/resources/static/js/")

if (!templatesDir.exists()) templatesDir.mkdirs()
if (!cssDir.exists()) cssDir.mkdirs()
if (!jsDir.exists()) jsDir.mkdirs()

srcPath.listFiles().forEach {
    val fileName = it.name
    when {
        fileName.endsWith(".html") -> {
            println("Copy file: $fileName")

            val htmlFile = File("$templatesPath$fileName")
            it.copyTo(target = htmlFile, overwrite = true)
            replaceJsCssSrc(htmlFile)
        }
        fileName.endsWith(".js") -> {
            println("Copy file: $fileName")
            it.copyTo(target = File("$jsFile$fileName"), overwrite = true)
        }
        fileName.endsWith(".css") -> {
            println("Copy file: $fileName")
            it.copyTo(target = File("$cssPath$fileName"), overwrite = true)
        }
    }
}




fun replaceJsCssSrc(htmlFile: File) {
    val oldJsSrc = """<script src="/"""
    val oldJsSrcParticular = """<script src="//"""
    val newJsSrc = """<script src="/js/"""

    val oldCssSrc = """<link rel="stylesheet" href="/"""
    val newCssSrc = """<link rel="stylesheet" href="/css/"""

    var lines = StringBuilder()
    htmlFile.readLines().forEach {
        var line = it
        if (line.contains(oldJsSrc) && !line.contains(oldJsSrcParticular)) {
            line = line.replace(oldJsSrc, newJsSrc)
        } else if (line.contains(oldCssSrc)) {
            line = line.replace(oldCssSrc, newCssSrc)
        }

        lines.append(line + "\n")
    }

    htmlFile.writeText(lines.toString())
}
