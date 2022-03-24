package ui.ex1.screen.facets.screenfacet;

import io.jmix.core.common.util.ParamsMap;
import io.jmix.ui.component.Button;
import io.jmix.ui.component.ScreenFacet;
import io.jmix.ui.screen.*;
import org.springframework.beans.factory.annotation.Autowired;
import ui.ex1.screen.entity.customer.CustomerBrowse;

@UiController("sample_ScreenFacetScreen")
@UiDescriptor("screen-facet-screen.xml")
public class ScreenFacetScreen extends Screen {

    // tag::options-provider[]
    @Install(to = "propScreenFacet", subject = "optionsProvider")
    private ScreenOptions propScreenFacetOptionsProvider() {
        return new MapScreenOptions(ParamsMap.of("num", 55));
    }
    // end::options-provider[]

    // tag::show[]
    @Autowired
    private ScreenFacet<Screen> screenFacet;

    @Subscribe("btn")
    public void onBtnClick(Button.ClickEvent event) {
        screenFacet.show();
    }
    // end::show[]
    // tag::screen-configurer[]
    @Install(to = "screenFacetC", subject = "screenConfigurer")
    protected void screenFacetCScreenConfigurer(CustomerBrowse customerBrowse) {
        customerBrowse.setSomeParameter(55);
    }
    // end::screen-configurer[]
}