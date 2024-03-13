
(defun farenheit-to-celsius (f)
  (let ((c (* (- f 32) 5/9))) 
    c))

(format t "La temperatura en celsius es: ~A" (farenheit-to-celsius 32))
