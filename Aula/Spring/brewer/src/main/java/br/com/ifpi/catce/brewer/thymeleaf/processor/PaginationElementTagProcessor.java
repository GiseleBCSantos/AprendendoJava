package br.com.ifpi.catce.brewer.thymeleaf.processor;

import org.thymeleaf.context.ITemplateContext;
import org.thymeleaf.model.IAttribute;
import org.thymeleaf.model.IModel;
import org.thymeleaf.model.IModelFactory;
import org.thymeleaf.model.IProcessableElementTag;
import org.thymeleaf.processor.element.AbstractElementTagProcessor;
import org.thymeleaf.processor.element.IElementTagStructureHandler;
import org.thymeleaf.templatemode.TemplateMode;

public class PaginationElementTagProcessor extends AbstractElementTagProcessor {
    private static final String TAG_NAME = "pagination";
    private static final int PRECEDENCE = 1000;

    public PaginationElementTagProcessor(String dialectPrefix) {
        super(TemplateMode.HTML, dialectPrefix, TAG_NAME, true, null, false, PRECEDENCE);
    }

    @Override
    protected void doProcess(ITemplateContext context, IProcessableElementTag tag, IElementTagStructureHandler structureHandler) {
        IModelFactory modelFactory = context.getModelFactory();

        IAttribute pagination = tag.getAttribute("pagination");

        IModel model = modelFactory.createModel();
        model.add(modelFactory.createStandaloneElementTag("th:block", "th:replace", String.format("fragments/Paginacao :: pagination (%s)", pagination.getValue())));

        structureHandler.replaceWith(model, true);
    }
}
