/**
 */
package tdt4250.pseudocode.provider;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

import tdt4250.pseudocode.PseudoType;
import tdt4250.pseudocode.PseudocodeFactory;
import tdt4250.pseudocode.PseudocodePackage;

/**
 * This is the item provider adapter for a {@link tdt4250.pseudocode.PseudoType} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class PseudoTypeItemProvider extends MemberItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PseudoTypeItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

			addSuperTypesPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Super Types feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSuperTypesPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_PseudoType_superTypes_feature"),
						getString("_UI_PropertyDescriptor_description", "_UI_PseudoType_superTypes_feature",
								"_UI_PseudoType_type"),
						PseudocodePackage.Literals.PSEUDO_TYPE__SUPER_TYPES, true, false, true, null, null, null));
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(PseudocodePackage.Literals.PSEUDO_TYPE__MEMBERS);
		}
		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected boolean shouldComposeCreationImage() {
		return true;
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((PseudoType) object).getName();
		return label == null || label.length() == 0 ? getString("_UI_PseudoType_type")
				: getString("_UI_PseudoType_type") + " " + label;
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(PseudoType.class)) {
		case PseudocodePackage.PSEUDO_TYPE__MEMBERS:
			fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
			return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);

		newChildDescriptors.add(createChildParameter(PseudocodePackage.Literals.PSEUDO_TYPE__MEMBERS,
				PseudocodeFactory.eINSTANCE.createMember()));

		newChildDescriptors.add(createChildParameter(PseudocodePackage.Literals.PSEUDO_TYPE__MEMBERS,
				PseudocodeFactory.eINSTANCE.createPseudoClass()));

		newChildDescriptors.add(createChildParameter(PseudocodePackage.Literals.PSEUDO_TYPE__MEMBERS,
				PseudocodeFactory.eINSTANCE.createPseudoInterface()));

		newChildDescriptors.add(createChildParameter(PseudocodePackage.Literals.PSEUDO_TYPE__MEMBERS,
				PseudocodeFactory.eINSTANCE.createField()));

		newChildDescriptors.add(createChildParameter(PseudocodePackage.Literals.PSEUDO_TYPE__MEMBERS,
				PseudocodeFactory.eINSTANCE.createOperation()));

		newChildDescriptors.add(createChildParameter(PseudocodePackage.Literals.PSEUDO_TYPE__MEMBERS,
				PseudocodeFactory.eINSTANCE.createMethod()));

		newChildDescriptors.add(createChildParameter(PseudocodePackage.Literals.PSEUDO_TYPE__MEMBERS,
				PseudocodeFactory.eINSTANCE.createConstructor()));
	}

}