(defun factorial (n)
  (loop for i from 1 to n
        for result = 1 then (* result i)
        finally (return result)))

(format t "El factorial del numero n es: ~a~%" (factorial 5))

