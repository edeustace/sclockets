package com.ee.sclockets.processors

import java.io.File
import org.specs2.mutable.Specification

class DirectiveProcessorSpec extends Specification{

  val rootFolder = s"modules/core/src/test/resources/${this.getClass.getName.replace(".", "/")}"

  "DirectiveProcessor" should {

    "work" in {
      DirectiveProcessor.process( new File( s"$rootFolder/one.js" )) ===
        Seq( new File(s"$rootFolder/one.js"), new File(s"$rootFolder/two.js"))
    }
  }
}