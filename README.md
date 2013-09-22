## Sclockets

A scala asset pipeline manager base on [sprockets](https://github.com/sstephenson/sprockets).

### Version: Not ready for use.

## Usage

You'll need to load and configure the `Sclockets.Environment` in your application. Depending on what framework you use this is done differently...

## Core Usage

    com.ee.Sclockets.mount('/assets')
    com.ee.Sclockets.appendPath('app/assets/javascripts')

    # def.js
    //= require 'one' //look for one.js in app/assets/javascript --> <script src="/assets/def.js"><script src="/assets/one.js">

### Play Plugin

1. Add plugin to play.plugins

2. GET -> /assets sclockets.Routes

3. In your template call sclockets: `com.ee.Sclockets.js('ref.js')` - ref.js is on the load path
