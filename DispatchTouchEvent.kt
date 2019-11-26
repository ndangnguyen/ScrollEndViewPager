override fun dispatchTouchEvent(event: MotionEvent?): Boolean {
        when (event?.action) {
            MotionEvent.ACTION_DOWN -> x1 = event.x
            MotionEvent.ACTION_MOVE -> {
                x2 = event.x
                val deltaX = x2 - x1
                if (abs(deltaX) > MIN_DISTANCE) {
                    viewModel.isSlideLeftToRight = deltaX > 0
                }

            }
        }
        return super.dispatchTouchEvent(event)
    }
