val sharedViewModel = sharedViewModel ?: return
        val pageCount = (viewPager.adapter as ItemTypeViewPagerAdapter).count
        var selectedPageIndex = 0
        var isPageEnd = false

        viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {
                if (ViewPager.SCROLL_STATE_DRAGGING == state)
                    isPageEnd = selectedPageIndex == pageCount - 1
            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
                if (isPageEnd && selectedPageIndex == position && !sharedViewModel.isSlideLeftToRight) {
                    sharedViewModel.onScrollToTakeOutMenu.value = true
                    isPageEnd = false
                }
            }

            override fun onPageSelected(position: Int) {
                selectedPageIndex = position
            }

        })
