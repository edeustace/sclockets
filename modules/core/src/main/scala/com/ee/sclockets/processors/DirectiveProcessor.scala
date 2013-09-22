package com.ee.sclockets.processors

  import java.io.File
  //import grizzled.file.GrizzledFile._

  trait PreProcessor {

  }

  /**
  * The `DirectiveProcessor` is responsible for parsing and evaluating
  * directive comments in a source file.
  *
  * A directive comment starts with a comment prefix, followed by an "=",
  * then the directive name, then any arguments.
  *
  *     // JavaScript
  *     //= require "foo"
  *
  * The Processor is implemented as a `Tilt::Template` and is loosely
  * coupled to Sprockets. This makes it possible to disable or modify
  * the processor to do whatever you'd like. You could add your own
  * custom directives or invent your own directive syntax.
  *
  * `Environment*processors` includes `DirectiveProcessor` by default.
  *
  * To remove the processor entirely:
  *
  *     env.unregister_processor('text/css', Sprockets::DirectiveProcessor)
  *     env.unregister_processor('application/javascript', Sprockets::DirectiveProcessor)
  *
  * Then inject your own preprocessor:
  *
  *     env.register_processor('text/css', MyProcessor)
  */


  object DirectiveProcessor extends PreProcessor{

    def process(f:File) : Seq[File] = {
      val requires = scala.io.Source.fromFile(f).getLines.filter(_.startsWith("//= require"))
      val dependentFiles = requires.map( loadDependendant(f) )
      Seq(f) ++ dependentFiles.flatten
    }

    private def loadDependendant(root : File)( s : String) : Option[File] = {
        val Regex = """//= require "?(.*?)"?""".r
        val Regex(path) = s
        val logicalPath = s"${root.getParentFile.getPath}/$path"
        val f = new File(logicalPath + ".js")
        if(!f.exists){
          throw new RuntimeException( s"$logicalPath doesn't exist")
        } else {
          Some(f)
        }

    }
  }