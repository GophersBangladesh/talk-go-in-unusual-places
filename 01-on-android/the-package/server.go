package unusualgoandroid

import (
	"fmt"
	"net/http"
)

func helloHandler(w http.ResponseWriter, r *http.Request) {
	fmt.Fprintln(w, "Hello, World!")
}

func Serve() {
	http.HandleFunc("/", helloHandler)
	http.ListenAndServe(":8080", nil)
}
