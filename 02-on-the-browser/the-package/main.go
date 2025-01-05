package main

import (
	"syscall/js"
)

func Greeting(this js.Value, args []js.Value) interface{} {
	return js.ValueOf("Hello " + args[0].String())
}

func main() {
	js.Global().Set("greeting", js.FuncOf(Greeting))

	select {}
}
