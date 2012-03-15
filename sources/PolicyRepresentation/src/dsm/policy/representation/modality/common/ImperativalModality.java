/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dsm.policy.representation.modality.common;

/**
 *
 * @author morteza
 */
public abstract class ImperativalModality implements IModality{
    public ImperativalModality() {
    }

    @Override
    public PolicyModalityType GetModalityType() {
        return PolicyModalityType.Imperatival;
    }
}
