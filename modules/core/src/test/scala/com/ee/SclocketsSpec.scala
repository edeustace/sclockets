package com.ee.sclockets

import org.specs2.mutable.Specification

class SclocketsSpec extends Specification{

  "Sclockets" should {

    "work" in {
      Sclockets.mount("/blah")
      Sclockets.appendPath("src/test/resources/one")
      Sclockets.load("/blah/one.js").map{ script =>
          script === """<script type="text/javascript" src="/blah/one.js"></script>"""
      }.getOrElse(failure("no script found"))

      true === true
    }
  }
}