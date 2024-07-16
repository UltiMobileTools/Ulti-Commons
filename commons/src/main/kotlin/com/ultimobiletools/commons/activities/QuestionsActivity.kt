package com.ultimobiletools.commons.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.remember
import com.ultimobiletools.commons.compose.extensions.enableEdgeToEdgeUlti
import com.ultimobiletools.commons.compose.screens.FAQScreen
import com.ultimobiletools.commons.compose.theme.AppThemeSurface
import com.ultimobiletools.commons.helpers.APP_FAQ
import com.ultimobiletools.commons.models.FAQItem
import kotlinx.collections.immutable.toImmutableList

class QuestionsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdgeUlti()
        setContent {
            AppThemeSurface {
                val faqItems = remember { intent.getSerializableExtra(APP_FAQ) as ArrayList<FAQItem> }
                FAQScreen(
                    goBack = ::finish,
                    faqItems = faqItems.toImmutableList()
                )
            }
        }
    }
}
