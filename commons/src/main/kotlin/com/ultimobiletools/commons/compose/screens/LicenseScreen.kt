package com.ultimobiletools.commons.compose.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.ListItem
import androidx.compose.material3.ListItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.ultimobiletools.commons.R
import com.ultimobiletools.commons.compose.extensions.MyDevices
import com.ultimobiletools.commons.compose.lists.SimpleLazyListScaffold
import com.ultimobiletools.commons.compose.settings.SettingsHorizontalDivider
import com.ultimobiletools.commons.compose.theme.AppThemeSurface
import com.ultimobiletools.commons.compose.theme.SimpleTheme
import com.ultimobiletools.commons.helpers.*
import com.ultimobiletools.commons.models.CustomLicense
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toImmutableList

@Composable
internal fun LicenseScreen(
    goBack: () -> Unit,
    thirdPartyLicens: ImmutableList<CustomLicense>,
    onLicenseClick: (urlId: Int) -> Unit,
) {
    SimpleLazyListScaffold(
        title = stringResource(id = R.string.third_party_licences),
        goBack = goBack
    ) {
        itemsIndexed(thirdPartyLicens) { index, license ->
            Column {
                LicenseItem(license, onLicenseClick)
                if (index != thirdPartyLicens.lastIndex) {
                    SettingsHorizontalDivider(modifier = Modifier.padding(bottom = SimpleTheme.dimens.padding.small))
                }
            }
        }
    }
}

@Composable
private fun LicenseItem(
    customLicense: CustomLicense,
    onLicenseClick: (urlId: Int) -> Unit
) {
    ListItem(headlineContent = {
        Text(
            text = stringResource(id = customLicense.titleId),
            modifier = Modifier
                .clickable {
                    onLicenseClick(customLicense.urlId)
                }
        )
    }, supportingContent = {
        Text(
            text = stringResource(id = customLicense.textId),
            modifier = Modifier.padding(top = SimpleTheme.dimens.padding.extraSmall),
        )
    }, colors = ListItemDefaults.colors(headlineColor = SimpleTheme.colorScheme.primary, supportingColor = SimpleTheme.colorScheme.onSurface))
}

@Composable
@MyDevices
private fun LicenseScreenPreview() {
    AppThemeSurface {
        LicenseScreen(
            goBack = {},
            thirdPartyLicens = listOf(
                CustomLicense(
                    LICENSE_KOTLIN,
                    R.string.kotlin_title,
                    R.string.kotlin_text,
                    R.string.kotlin_url
                ),
                CustomLicense(
                    LICENSE_SUBSAMPLING,
                    R.string.subsampling_title,
                    R.string.subsampling_text,
                    R.string.subsampling_url
                ),
                CustomLicense(LICENSE_GLIDE, R.string.glide_title, R.string.glide_text, R.string.glide_url),
                CustomLicense(
                    LICENSE_CROPPER,
                    R.string.cropper_title,
                    R.string.cropper_text,
                    R.string.cropper_url
                ),
                CustomLicense(
                    LICENSE_RTL,
                    R.string.rtl_viewpager_title,
                    R.string.rtl_viewpager_text,
                    R.string.rtl_viewpager_url
                ),
                CustomLicense(LICENSE_JODA, R.string.joda_title, R.string.joda_text, R.string.joda_url),
                CustomLicense(
                    LICENSE_STETHO,
                    R.string.stetho_title,
                    R.string.stetho_text,
                    R.string.stetho_url
                ),
                CustomLicense(LICENSE_OTTO, R.string.otto_title, R.string.otto_text, R.string.otto_url),
                CustomLicense(
                    LICENSE_PHOTOVIEW,
                    R.string.photoview_title,
                    R.string.photoview_text,
                    R.string.photoview_url
                ),
                CustomLicense(
                    LICENSE_PICASSO,
                    R.string.picasso_title,
                    R.string.picasso_text,
                    R.string.picasso_url
                ),
                CustomLicense(
                    LICENSE_PATTERN,
                    R.string.pattern_title,
                    R.string.pattern_text,
                    R.string.pattern_url
                ),
                CustomLicense(
                    LICENSE_REPRINT,
                    R.string.reprint_title,
                    R.string.reprint_text,
                    R.string.reprint_url
                ),
                CustomLicense(
                    LICENSE_GIF_DRAWABLE,
                    R.string.gif_drawable_title,
                    R.string.gif_drawable_text,
                    R.string.gif_drawable_url
                ),
                CustomLicense(
                    LICENSE_AUTOFITTEXTVIEW,
                    R.string.autofittextview_title,
                    R.string.autofittextview_text,
                    R.string.autofittextview_url
                ),
                CustomLicense(
                    LICENSE_ROBOLECTRIC,
                    R.string.robolectric_title,
                    R.string.robolectric_text,
                    R.string.robolectric_url
                ),
                CustomLicense(
                    LICENSE_ESPRESSO,
                    R.string.espresso_title,
                    R.string.espresso_text,
                    R.string.espresso_url
                ),
                CustomLicense(LICENSE_GSON, R.string.gson_title, R.string.gson_text, R.string.gson_url),
                CustomLicense(
                    LICENSE_LEAK_CANARY,
                    R.string.leak_canary_title,
                    R.string.leakcanary_text,
                    R.string.leakcanary_url
                ),
                CustomLicense(
                    LICENSE_NUMBER_PICKER,
                    R.string.number_picker_title,
                    R.string.number_picker_text,
                    R.string.number_picker_url
                ),
                CustomLicense(
                    LICENSE_EXOPLAYER,
                    R.string.exoplayer_title,
                    R.string.exoplayer_text,
                    R.string.exoplayer_url
                ),
                CustomLicense(
                    LICENSE_PANORAMA_VIEW,
                    R.string.panorama_view_title,
                    R.string.panorama_view_text,
                    R.string.panorama_view_url
                ),
                CustomLicense(
                    LICENSE_SANSELAN,
                    R.string.sanselan_title,
                    R.string.sanselan_text,
                    R.string.sanselan_url
                ),
                CustomLicense(
                    LICENSE_FILTERS,
                    R.string.filters_title,
                    R.string.filters_text,
                    R.string.filters_url
                ),
                CustomLicense(
                    LICENSE_GESTURE_VIEWS,
                    R.string.gesture_views_title,
                    R.string.gesture_views_text,
                    R.string.gesture_views_url
                ),
                CustomLicense(
                    LICENSE_INDICATOR_FAST_SCROLL,
                    R.string.indicator_fast_scroll_title,
                    R.string.indicator_fast_scroll_text,
                    R.string.indicator_fast_scroll_url
                ),
                CustomLicense(
                    LICENSE_EVENT_BUS,
                    R.string.event_bus_title,
                    R.string.event_bus_text,
                    R.string.event_bus_url
                ),
                CustomLicense(
                    LICENSE_AUDIO_RECORD_VIEW,
                    R.string.audio_record_view_title,
                    R.string.audio_record_view_text,
                    R.string.audio_record_view_url
                ),
                CustomLicense(
                    LICENSE_SMS_MMS,
                    R.string.sms_mms_title,
                    R.string.sms_mms_text,
                    R.string.sms_mms_url
                ),
                CustomLicense(LICENSE_APNG, R.string.apng_title, R.string.apng_text, R.string.apng_url),
                CustomLicense(
                    LICENSE_PDF_VIEW_PAGER,
                    R.string.pdf_view_pager_title,
                    R.string.pdf_view_pager_text,
                    R.string.pdf_view_pager_url
                ),
                CustomLicense(
                    LICENSE_M3U_PARSER,
                    R.string.m3u_parser_title,
                    R.string.m3u_parser_text,
                    R.string.m3u_parser_url
                ),
                CustomLicense(
                    LICENSE_ANDROID_LAME,
                    R.string.android_lame_title,
                    R.string.android_lame_text,
                    R.string.android_lame_url
                ),
                CustomLicense(
                    LICENSE_PDF_VIEWER,
                    R.string.pdf_viewer_title,
                    R.string.pdf_viewer_text,
                    R.string.pdf_viewer_url
                ),
                CustomLicense(LICENSE_ZIP4J, R.string.zip4j_title, R.string.zip4j_text, R.string.zip4j_url)
            ).toImmutableList()
        ) {

        }
    }
}

