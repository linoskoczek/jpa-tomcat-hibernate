package website.resources;

import tpo4.Resource;

import java.util.List;

public class ResourcesModel implements IResourceModelList {
    private List<Resource> resourceList;

    ResourcesModel(List<Resource> resourceList) {
        this.resourceList = resourceList;
    }

    @Override
    public List<Resource> getResources() {
        return resourceList;
    }
}
