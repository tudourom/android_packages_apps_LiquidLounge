/*
 * Copyright (C) 2017 The Nitrogen Project
 * Copyright (C) 2017 The Liquid Remix Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.liquid.liquidlounge.fragments;

import android.didikee.donate.AlipayDonate;
import android.os.Bundle;
import android.content.Context;
import android.widget.Toast;

import com.android.settings.R;
import com.android.internal.logging.nano.MetricsProto;
import com.android.settings.SettingsPreferenceFragment;

public class DonateSettings extends SettingsPreferenceFragment {

    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        Context context = getContext();
        if (!AlipayDonate.hasInstalledAlipayClient(context)) {
            android.widget.Toast.makeText(context, "未安装支付宝", Toast.LENGTH_SHORT).show();
            addPreferencesFromResource(R.xml.donate_settings);
        } else{
            addPreferencesFromResource(R.xml.donate_thanks);
            AlipayDonate.startAlipayClient(getActivity(), "FKX01788WGKC87XS3N1171");
        }
    }

    @Override
    public int getMetricsCategory() {
        return MetricsProto.MetricsEvent.LIQUID;
    }
}
