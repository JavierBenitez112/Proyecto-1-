(defun fibonacci (n)
  (cond
    ((equal n 0) 0)
    ((equal n 1) 1)
    ((> n 1) (+ (fibonacci (- n 1)) (fibonacci (- n 2))))))


(format t "El término 10 de la secuencia de Fibonacci es: ~a~%" (fibonacci 10))
