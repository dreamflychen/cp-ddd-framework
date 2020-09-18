package org.example.bp.oms.ka;

import lombok.extern.slf4j.Slf4j;
import org.cdf.ddd.annotation.Extension;
import org.cdf.ddd.plugin.IContainerContext;
import org.cdf.ddd.plugin.IPluginListener;
import org.example.cp.oms.spec.ext.ISensitiveWordsExt;
import org.example.cp.oms.spec.model.IOrderModel;
import org.example.cp.oms.spec.partner.KaPartner;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;

@Slf4j
@Component(value = "kaPluginListener")
public class PluginListener implements IPluginListener {

    @Override
    public void onLoad(IContainerContext ctx) throws Exception {
        log.info("KA Jar loaded, ctx:{}", ctx);

        // 手工注册扩展点实例
        //ctx.registerBean(Extension.class, new SensitiveWordsExt());
    }

    @Override
    public void onUnload(IContainerContext ctx) throws Exception {

    }

    @Extension(code = KaPartner.CODE)
    public static class SensitiveWordsExt implements ISensitiveWordsExt {

        @Override
        public String[] extract(@NotNull IOrderModel model) {
            return new String[0];
        }
    }
}
