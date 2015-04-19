require 'test_helper'

class IntsControllerTest < ActionController::TestCase
  setup do
    @int = ints(:one)
  end

  test "should get index" do
    get :index
    assert_response :success
    assert_not_nil assigns(:ints)
  end

  test "should get new" do
    get :new
    assert_response :success
  end

  test "should create int" do
    assert_difference('Int.count') do
      post :create, int: { num: @int.num }
    end

    assert_redirected_to int_path(assigns(:int))
  end

  test "should show int" do
    get :show, id: @int
    assert_response :success
  end

  test "should get edit" do
    get :edit, id: @int
    assert_response :success
  end

  test "should update int" do
    patch :update, id: @int, int: { num: @int.num }
    assert_redirected_to int_path(assigns(:int))
  end

  test "should destroy int" do
    assert_difference('Int.count', -1) do
      delete :destroy, id: @int
    end

    assert_redirected_to ints_path
  end
end
