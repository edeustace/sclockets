package com.ee.sclockets

import processors._
import java.io.File

case class Configuration(
  preProcessors : Map[String,PreProcessor] = Map(
    "text/css" -> DirectiveProcessor,
    "application/javascript" -> DirectiveProcessor
  )
)

trait FileContext{

  def logicalPath : String
  def absolutePath : String

  def files : Seq[File]
}

object FileContext{

  def apply(f:File, processor : PreProcessor) : FileContext = {
    null
  }
}


object Sclockets{

  private var mountPath : String = "/assets"

  private var loadPaths : Seq[String] = Seq("app/assets/javascript")

  /**
   * Mount Sclockets at this url path eg "/assets".
   * When the request comes for "/assets/myfile.js", sclockets will look for this file on the
   * load path.
   */
  def mount(mountPath: String) : Unit  = {
    this.mountPath = mountPath
  }

  /**
   * Returns a scripts (or a set of script) node(s).
   * Client template:
   * Sclockets.load("/blah/one.js") => <script>...</script>
   */
  def load(p:String) : Option[String] = {
    None
  }

  /**
   * Load the string contents of the given logical path
   */
  def loadContents(p:String) : Option[String] = {
    None
  }

  def appendPath(path: String) : Unit =   {
    this.loadPaths = this.loadPaths :+ path
  }

}