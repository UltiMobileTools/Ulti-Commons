package com.ultimobiletools.commons.compose.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.ListItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ultimobiletools.commons.compose.components.LinkifyTextComponent
import com.ultimobiletools.commons.compose.extensions.MyDevices
import com.ultimobiletools.commons.compose.lists.UltiLazyListScaffold
import com.ultimobiletools.commons.compose.settings.SettingsHorizontalDivider
import com.ultimobiletools.commons.compose.theme.AppThemeSurface
import com.ultimobiletools.commons.compose.theme.UltiTheme
import com.ultimobiletools.commons.extensions.fromHtml
import com.ultimobiletools.commons.models.FAQItem
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toImmutableList
import com.ultimobiletools.commons.R

@Composable
internal fun FAQScreen(
    goBack: () -> Unit,
    faqItems: ImmutableList<FAQItem>,
) {
    UltiLazyListScaffold(
        title = stringResource(id = R.string.frequently_asked_questions),
        goBack = goBack,
        contentPadding = PaddingValues(bottom = UltiTheme.dimens.padding.medium)
    ) {
        itemsIndexed(faqItems) { index, faqItem ->
            Column(modifier = Modifier.fillMaxWidth()) {
                ListItem(
                    headlineContent = {
                        val text = if (faqItem.title is Int) stringResource(faqItem.title) else faqItem.title as String
                        Text(
                            text = text,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(bottom = 6.dp),
                            color = UltiTheme.colorScheme.primary,
                            lineHeight = 16.sp,
                        )
                    },
                    supportingContent = {
                        if (faqItem.text is Int) {
                            val text = stringResource(id = faqItem.text).fromHtml()
                            LinkifyTextComponent(
                                text = { text },
                                modifier = Modifier.fillMaxWidth(),
                                fontSize = 14.sp
                            )
                        } else {
                            Text(
                                text = faqItem.text as String,
                                modifier = Modifier.fillMaxWidth(),
                                fontSize = 14.sp
                            )
                        }
                    },
                )
                Spacer(modifier = Modifier.padding(bottom = UltiTheme.dimens.padding.medium))
                if (index != faqItems.lastIndex) {
                    SettingsHorizontalDivider(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = UltiTheme.dimens.padding.small)
                    )
                }
            }
        }
    }
}

@MyDevices
@Composable
private fun FAQScreenPreview() {
    AppThemeSurface {
        FAQScreen(
            goBack = {},
            faqItems = listOf(
                FAQItem(R.string.faq_1_title_commons, R.string.faq_1_text_commons),
                FAQItem(R.string.faq_1_title_commons, R.string.faq_1_text_commons),
                FAQItem(R.string.faq_4_title_commons, R.string.faq_4_text_commons),
                FAQItem(R.string.faq_2_title_commons, R.string.faq_2_text_commons),
                FAQItem(R.string.faq_6_title_commons, R.string.faq_6_text_commons)
            ).toImmutableList()
        )
    }
}
