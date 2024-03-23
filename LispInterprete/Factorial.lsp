(defun Factorial (n)
  (cond
    ((equal n 0) 1)
    ((> n 0) (* n (Factorial (- n 1))))
    ))


(format t "El factorial del numero n es: ~a~%" (Factorial 5))

