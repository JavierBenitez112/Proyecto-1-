(defun fibonacci (n)
  (let* ((sqrt5 (sqrt 5))
         (phi (/ (+ 1 sqrt5) 2))
         (psi (/ (- 1 sqrt5) 2))
         (fib-numerator (- (expt phi n) (expt psi n))))
    (/ fib-numerator sqrt5)))


(format t "El término 10 de la secuencia de Fibonacci es: ~a~%" (fibonacci 10))
